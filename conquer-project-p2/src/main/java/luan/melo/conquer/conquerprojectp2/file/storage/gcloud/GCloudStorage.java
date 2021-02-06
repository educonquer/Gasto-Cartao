package luan.melo.conquer.conquerprojectp2.file.storage.gcloud;

import luan.melo.conquer.conquerprojectp2.domain.Execucao;
import luan.melo.conquer.conquerprojectp2.file.storage.FilePointer;

import java.io.File;

public interface GCloudStorage
{
	byte[] download(String location)
		throws Exception;
	
	void upload(Execucao execucao, File file)
		throws Exception;
}
