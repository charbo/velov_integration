package fr.charbo.velov.integration;

import java.util.Calendar;
import java.util.Date;

import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.stereotype.Service;

@Service("transformer")
public class Transformer implements GenericTransformer<Station, StationDTO>{

	public StationDTO transform(Station station) {
		StationDTO result = new StationDTO();
		StationKey key = new StationKey();
		key.setId(station.getUpdateTime());
		key.setIdStation(station.getIdStation());		
		result.setStationKey(key);
		
		result.setName(station.getName());
		result.setTotales(station.getBikeStands());
		result.setStatut(station.getStatus());
		result.setDisponibles(station.getDisponibles());
		result.setOccupees(station.getOccupees());

		Calendar calendar = Calendar.getInstance();
		Date date = new Date(station.getUpdateTime());
		calendar.setTime(date);
		
		result.setDate(date);
		result.setHeure(calendar.get(Calendar.HOUR_OF_DAY));
		result.setMois(calendar.get(Calendar.MONTH));
		result.setJour(calendar.get(Calendar.DAY_OF_MONTH));
		result.setNumeroJour(calendar.get(Calendar.DAY_OF_WEEK));
		result.setMinute(calendar.get(Calendar.MINUTE));
		
		result.setFull(station.getDisponibles() == 0 ? 1 : 0);
		
		result.setIntervalle(calendar.get(Calendar.MINUTE) / 5 + calendar.get(Calendar.HOUR_OF_DAY)*12);
				
		return result;
	}
	
}
