package br.com.dio.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.dio.Service.EventoEnum.CLEAR_ESPACO;

public class NotifierService {

    private final Map<EventoEnum, List<EventoListener>> listeners = new HashMap<>(){{
        put(CLEAR_ESPACO, new ArrayList<>());
    }};

    public void subscribe(final EventoEnum eventType, EventoListener listener){
        var selectedListeners = listeners.get(eventType);
        selectedListeners.add(listener);
    }

    public void notify(final EventoEnum eventType){
        listeners.get(eventType).forEach(l -> l.update(eventType));
    }

}
