package luan.melo.portal.transparencia.back.api.retrofit;

import luan.melo.portal.transparencia.back.domain.Gasto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

public interface GastoCartaoApi {

    @GET("api-de-dados/cartoes")
    Call<List<Gasto>> get(@QueryMap Map<String, String> options, @Header("chave-api-dados") String chave);
}
