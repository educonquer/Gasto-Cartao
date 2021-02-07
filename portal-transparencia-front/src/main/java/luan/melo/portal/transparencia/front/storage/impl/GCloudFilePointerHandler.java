package luan.melo.portal.transparencia.front.storage.impl;

import luan.melo.portal.transparencia.front.domain.Execucao;
import luan.melo.portal.transparencia.front.storage.gcloud.FilePointerHandler;
import luan.melo.portal.transparencia.front.storage.gcloud.GCloudStorage;
import luan.melo.portal.transparencia.front.storage.gcloud.impl.GCloudStorageImpl;

import java.io.File;

public class GCloudFilePointerHandler
	implements FilePointerHandler
{
	private GCloudStorage storage;

	private GCloudFilePointerHandler() throws Exception {
		storage = new GCloudStorageImpl();
		byte[] bytes = storage.download("gs://oystr-archive-test-sa/queue-files/2018/03/29/20180329.212059-rlirfi/amor.txt");
		System.out.println(new String(bytes));
	}
		
	@Override
	public byte[] get(Execucao execucao)
		throws Exception
	{
		String location = execucao.getLocalArquivo();
		String name     = execucao.getNomeArquivo();
		String object   = location + "/" + name;
		return storage.download(object);
	}
	
	public void upload(Execucao execucao, File file)
		throws Exception
	{
		storage.upload(execucao, file);
	}
}