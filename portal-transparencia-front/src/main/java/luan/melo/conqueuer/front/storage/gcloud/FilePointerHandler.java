package luan.melo.conqueuer.front.storage.gcloud;

import luan.melo.conqueuer.front.domain.Execucao;

import java.io.File;

public interface FilePointerHandler
{
	default byte[] get(String location, String name)
		throws Exception
	{
		return get(Execucao.builder().localArquivo(location).nomeArquivo(name).build());
	}

	byte[] get(Execucao execucao)
		throws Exception;

	void upload(Execucao execucao, File file)
		throws Exception;
}
