package luan.melo.portal.transparencia.front.storage.gcloud.impl;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.*;
import luan.melo.portal.transparencia.front.domain.Execucao;
import luan.melo.portal.transparencia.front.storage.gcloud.GCloudStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GCloudStorageImpl
	implements GCloudStorage
{
	private File               key;

	private Storage            storage;

	private Logger             logger   = LoggerFactory.getLogger(getClass());

	private Pattern            pattern  = Pattern.compile("^gs://([a-zA-Z0-9_\\-]+)/(.+)$");

	public GCloudStorageImpl() throws Exception {
		File file = new File("/opt/conquer/conquer.json");
		if(!file.exists() || !file.isFile())
		{
			throw new Exception("Can't find '" + "keyFile" + "'");
		}
		key = file;
		initialize();
	}

	public void initialize()
		throws Exception
	{
		try(InputStream is = new FileInputStream(key))
		{
			ServiceAccountCredentials cred = ServiceAccountCredentials.fromStream(is);
			storage = StorageOptions
				.newBuilder()
				.setCredentials(cred)
				.build()
				.getService();			
		}
	}

	@Override
	public byte[] download(String file)
		throws Exception
	{
		Matcher matcher = matcher(file);
		String bucket   = matcher.group(1);
		String path     = matcher.group(2);
		
		logger.info("Downloading file from bucket: '{}', path: '{}'", bucket, path);
		BlobId id = BlobId.of(bucket, path);
		try
		{
			return storage.readAllBytes(id);
		}
		catch(StorageException j)
		{
			if(j.getCode() == 404)
			{
				throw new Exception("Arquivo não enviado. (" + file + ")", j);
			}
			throw j;
		}
	}
	
	@Override
	public void upload(Execucao execucao, File file)
		throws Exception
	{
		String location   = execucao.getLocalArquivo();
		String name       = execucao.getNomeArquivo();
		Matcher matcher   = matcher(location);
		String bucketName = matcher.group(1);
		String path       = matcher.group(2);

		logger.info("Uploading file to bucket: '{}', path: '{}'", bucketName, path);
		byte[] bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
		String mime  = new MimetypesFileTypeMap().getContentType(name);

		Bucket bucket = storage.get(bucketName);
		Blob   blob   = bucket.create(path + name, bytes, mime);
		BlobId id     = blob.getBlobId();
		if(id == null)
		{
			throw new Exception("Couldn't upload file to bucket.");
		}
	}

	private Matcher matcher(String string)
		throws Exception
	{	
		Matcher matcher = pattern.matcher(string);
		if(!matcher.matches())
		{
			throw new Exception("Can't find '" + string + "'");
		}
		return matcher;
	}

	public static final void main(String[] args)
		throws Exception
	{
		File file = File.createTempFile(".txt", "arquivo");

		GCloudStorageImpl storage = new GCloudStorageImpl();
		byte[] bytes = storage.download("gs://conquer-api-storage/report-files/2021/02/06/20210206.030547-HONeQl.csv");
//		storage.upload(Execucao.builder().localArquivo("gs://conquer-api-storage/queue-files/2018/03/29/20180329.212059-rlirfi").nomeArquivo("20180329.212059-rlirfi.csv").build(), file);



//		System.out.println(new String(bytes));
	}
}