package luan.melo.conqueuer.front.storage.gcloud;

import luan.melo.conqueuer.front.domain.Execucao;

import java.io.File;

public interface GCloudStorage
{
	byte[] download(String location)
		throws Exception;
	
	void upload(Execucao execucao, File file)
		throws Exception;
}
