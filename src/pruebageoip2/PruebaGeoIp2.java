/*
 Programa para geolocalziar la ubicacion de una direccion IP
utilizando la base de datos de MAX MIND
 */
package pruebageoip2;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Continent;

/**
 *
 * @author Gustavo Rodriguez
 */
public class PruebaGeoIp2 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws com.maxmind.geoip2.exception.GeoIp2Exception
     */
    public static void main(String[] args) throws IOException, GeoIp2Exception {
             
        //Buscar la base de datos de Country
        File dbFile = new File("C:\\Users\\VP45640\\Downloads\\GeoLite2-Country.mmdb");
        
        File dbFileCity = new File("C:\\Users\\VP45640\\Downloads\\GeoLite2-City.mmdb");
        
        // This creates the DatabaseReader object,
        // which should be reused across lookups.
        DatabaseReader reader = new DatabaseReader.Builder(dbFile).build();
        DatabaseReader readerCity = new DatabaseReader.Builder(dbFileCity).build();
        
        //Direccion IP como entrada
        InetAddress ipAddress = InetAddress.getByName("2803:40e0::");
        
        CountryResponse response = reader.country(ipAddress);
        // Country Info
        Country country = response.getCountry();
        Continent country2 = response.getContinent();
        
        //City info
        CityResponse responseCity = readerCity.city(ipAddress);
        City city = responseCity.getCity();
        
        //Impresion de salida en pantalla
        System.out.println("Country IsoCode: "+ country.getIsoCode() ); 
        System.out.println("Country Name: "+ country.getName()); 
        System.out.println("City Name: "+ city.getName()); 
        System.out.println("Continet Name: "+ country2.getCode()); 
    }
}