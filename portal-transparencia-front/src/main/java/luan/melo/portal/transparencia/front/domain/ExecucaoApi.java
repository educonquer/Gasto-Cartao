package luan.melo.portal.transparencia.front.domain;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ExecucaoApi {

    @GET("execucoes")
    Call<List<Execucao>> listarTodasExecs();

    @GET("execucoes/{id}")
    Call<Execucao> listarPorId(@Path("id") Long id);
}
