package pl.pjatk.jazs15468nbp.NBP.Service;

import org.apache.tomcat.jni.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.pjatk.jazs15468nbp.Database.Enums.MineralType;
import pl.pjatk.jazs15468nbp.Database.Model.GoldInfo;
import pl.pjatk.jazs15468nbp.Database.Service.DatabaseService;
import pl.pjatk.jazs15468nbp.NBP.Model.Gold;
import pl.pjatk.jazs15468nbp.NBP.Rest.RestTemplateConfig;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class NbpService
{
    private String url = "http://api.nbp.pl/api/cenyzlota/";
    private final RestTemplateConfig restTemplateConfig;
    private final DatabaseService databaseService;

    public NbpService(RestTemplateConfig restTemplateConfig, DatabaseService databaseService)
    {
        this.databaseService = databaseService;
        this.restTemplateConfig = restTemplateConfig;
    }

    public void SetAverageCurrencyValue(LocalDate startDate, LocalDate endDate)
    {
        String customUrl = url + startDate.toString() + "/" + endDate.toString() + "/?format=json";

        Gold[] gold = restTemplateConfig.RestTemplate().getForObject(customUrl, Gold[].class);

        double value = 0;

        for (int i = 0; i < gold.length; i++)
        {
            value += gold[i].Cena;
        }

        value = value / (gold.length - 1);

        var goldInfo = new GoldInfo();
        goldInfo.setStartdate(startDate);
        goldInfo.setEnddate(endDate);
        goldInfo.setRequestdate(LocalDateTime.now());
        goldInfo.setMineraltype(MineralType.Gold);
        goldInfo.setMineralvalue(value);

        databaseService.AddGoldInfo(goldInfo);
    }
}
