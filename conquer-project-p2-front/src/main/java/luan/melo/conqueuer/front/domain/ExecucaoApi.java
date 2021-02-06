package luan.melo.conqueuer.front.domain;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

public interface ExecucaoApi {

    @GET("execucoes")
    Call<List<Execucao>> listarTodasExecs();

    @GET("execucoes/{id}")
    Call<Execucao> listarPorId(@Path("id") Long id);
}
