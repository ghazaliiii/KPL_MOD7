import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class CovidConfig {
    private String CONFIG1 = "celcius";
    private int CONFIG2 = 14;
    private String CONFIG3 = "Anda tidak diperbolehkan masuk ke dalam gedung ini";
    private String CONFIG4 = "Anda dipersilahkan untuk masuk ke dalam gedung ini";
    public CovidConfig(String lokasi){
        try {
            JSONParser jp = new JSONParser();
            Object obj = jp.parse(new FileReader(lokasi));
            JSONObject jsonObj = (JSONObject) obj;
            CONFIG1 = (String)jsonObj.get("satuan_suhu");
            CONFIG2 = (int)jsonObj.get("batas_hari_demam");
            CONFIG3 = (String)jsonObj.get("pesan_ditolak");
            CONFIG4 = (String)jsonObj.get("pesan_diterima");
        } catch (Exception ex) {
            WriteJson(lokasi);
        }
    }
    public void WriteJson(String lokasi){
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("satuan_suhu", this.CONFIG1);
        jsonObj.put("batas_hari_demam", this.CONFIG2);
        jsonObj.put("pesan_ditolak", this.CONFIG3);
        jsonObj.put("pesan_diterima", this.CONFIG4);
        try {
            FileWriter file = new FileWriter(lokasi);
            file.write(jsonObj.toString());
            file.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public void setSatuanSuhu(String sat){
        this.CONFIG1 = sat;
    }
    public void setBatasDemam(int hari){
        this.CONFIG2 = hari;
    }
    public void setPesanDitolak(String massege){
        this.CONFIG3 = massege;
    }
    public void setPesanDiterima(String massege){
        this.CONFIG4 = massege;
    }
    public String getSatuanSuhu(){
        return this.CONFIG1;
    }
    public int getBatasDemam(){
        return this.CONFIG2;
    }
    public String getPesanDitolak(){
        return this.CONFIG3;
    }
    public String getPesanDiterima(){
        return this.CONFIG4;
    }
}
