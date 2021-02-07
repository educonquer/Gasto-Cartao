package luan.melo.portal.transparencia.back.file.storage.gcloud;

import luan.melo.portal.transparencia.back.domain.Execucao;

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
