package pl.pjatk.jazs15468nbp.NBP.Controller;

import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> GetGoldInfo(@PathVariable String startDate, @PathVariable String endDate)
    {
        LocalDate start = TryParseLocalDate(startDate);
        LocalDate end = TryParseLocalDate(endDate);

        if (start != null && end != null)
        {
            double avgValue = nbpService.SetAverageCurrencyValue(start, end);
            return new ResponseEntity<>("Avg value is " + avgValue, HttpStatus.OK);
        }
        else
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
