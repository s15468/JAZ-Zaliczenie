package pl.pjatk.jazs15468nbp.Database.Service;

import org.springframework.stereotype.Service;
import pl.pjatk.jazs15468nbp.Database.Model.GoldInfo;
import pl.pjatk.jazs15468nbp.Database.Repository.DatabaseRepository;

import java.time.LocalDateTime;

@Service
public class DatabaseService
{
    private final DatabaseRepository databaseRepository;

    public DatabaseService(DatabaseRepository databaseRepository)
    {
        this.databaseRepository = databaseRepository;
    }

    public void AddGoldInfo(GoldInfo goldInfo)
    {
        databaseRepository.InsertGoldInfo(goldInfo.getMineraltype(), goldInfo.getStartdate(), goldInfo.getEnddate(), goldInfo.getMineralvalue(), LocalDateTime.now());
    }
}
