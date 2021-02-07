package luan.melo.portal.transparencia.front.storage.gcloud;

import luan.melo.portal.transparencia.front.domain.Execucao;

import java.io.File;

public interface GCloudStorage
{
	byte[] download(String location)
		throws Exception;
	
	void upload(Execucao execucao, File file)
		throws Exception;
}
