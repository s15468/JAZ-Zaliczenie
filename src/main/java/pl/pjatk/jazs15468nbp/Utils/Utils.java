package pl.pjatk.jazs15468nbp.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Utils
{
    public static LocalDate TryParseLocalDate(String value)
    {
        try
        {
            return LocalDate.parse(value);
        }
        catch (DateTimeParseException e)
        {
            return null;
        }
    }
}
