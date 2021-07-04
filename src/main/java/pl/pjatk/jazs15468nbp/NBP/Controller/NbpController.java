package pl.pjatk.jazs15468nbp.NBP.Controller;

import org.apache.tomcat.jni.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.jazs15468nbp.NBP.Model.Gold;
import pl.pjatk.jazs15468nbp.NBP.Service.NbpService;

import java.time.LocalDate;

import static pl.pjatk.jazs15468nbp.Utils.Utils.TryParseLocalDate;

@RestController
@RequestMapping("/nbp")
public class NbpController
{
    private final NbpService nbpService;

    public NbpController(NbpService nbpService)
    {
        this.nbpService = nbpService;
    }

    @GetMapping("{startDate}/{endDate}")
    public ResponseEntity<Void> GetGoldInfo(@PathVariable String startDate, @PathVariable String endDate)
    {
        LocalDate start = TryParseLocalDate(startDate);
        LocalDate end = TryParseLocalDate(endDate);

        if (start != null && end != null)
        {
            nbpService.SetAverageCurrencyValue(start, end);
            return ResponseEntity.ok().build();
        }
        else
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
