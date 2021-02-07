package luan.melo.portal.transparencia.back.file.storage.gcloud;

import luan.melo.portal.transparencia.back.domain.Execucao;

import java.io.File;

public interface GCloudStorage
{
	byte[] download(String location)
		throws Exception;
	
	void upload(Execucao execucao, File file)
		throws Exception;
}
