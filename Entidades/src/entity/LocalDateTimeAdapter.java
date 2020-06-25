
package entity;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime>{
    
    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDateTime.parse(v);
    }
    @Override
    public String marshal(LocalDateTime date) throws Exception {
        if ( date == null ) return null;
        return date.toString();
    }

}
