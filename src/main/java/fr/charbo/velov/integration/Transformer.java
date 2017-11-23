package fr.charbo.velov.integration;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.stereotype.Service;

@Service("transformer")
public class Transformer implements GenericTransformer<Station, StationEntity> {
	private static final Logger LOG = LoggerFactory.getLogger(Transformer.class);

	private StationRepository stationRepository;

	@Autowired
	public Transformer(StationRepository stationRepository) {
		this.stationRepository = stationRepository;
	}

	public StationEntity transform(Station station) {
		LOG.debug("===================================");
		StationEntity previous = stationRepository.findMaxDateByStationKeyIdStation(station.getIdStation());
		LOG.debug("previous {}", previous);

		StationEntity result = new StationEntity();
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
		int heure = calendar.get(Calendar.HOUR_OF_DAY);
		result.setHeure(heure);
		result.setMois(calendar.get(Calendar.MONTH));
		result.setJour(calendar.get(Calendar.DAY_OF_MONTH));
		result.setNumeroJour(calendar.get(Calendar.DAY_OF_WEEK));
		int minute = calendar.get(Calendar.MINUTE);
		result.setMinute(minute);

		int intervalle = heure * 12 + minute / 5;
		int intervalle15 = heure * 4 + minute / 15;

		int full = station.getDisponibles() == 0 ? 1 : 0;
		int empty = station.getBikeStands() == 0 ? 1 : 0;
		result.setFull(full);
		result.setEmpty(empty);

		int velovIn = 0;
		int velovOut = 0;
		if (previous != null) {
			long lastUpdate = date.getTime() - previous.getDate().getTime();
			if (full == 1) {
				if (previous.getFull() == 1) {
					result.setTempsPleine(previous.getTempsPleine()
							+ lastUpdate);
				}
			}
			if (empty == 1) {
				if (previous.getEmpty() == 1) {
					result.setTempsVide(previous.getTempsPleine() + lastUpdate);
				}
			}

			if (station.getUpdateTime() == previous.getStationKey().getId()) {
				velovIn = previous.getVelovIn();
				velovOut = previous.getVelovOut();
			} else {
				int delta = station.getDisponibles().intValue()
						- previous.getDisponibles();
				if (delta > 0) {
					velovIn = delta;
					velovOut = 0;
				} else {
					velovIn = 0;
					velovOut = delta;
				}
			}
		} 
		result.setVelovIn(velovIn);
		result.setVelovOut(velovOut);

		result.setIntervalle(intervalle);
		result.setIntervalle15(intervalle15);

		return result;
	}

}
