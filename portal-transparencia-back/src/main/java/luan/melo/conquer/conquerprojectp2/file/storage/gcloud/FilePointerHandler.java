package luan.melo.conquer.conquerprojectp2.file.storage.gcloud;

import luan.melo.conquer.conquerprojectp2.domain.Execucao;
import luan.melo.conquer.conquerprojectp2.file.storage.FilePointer;

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
