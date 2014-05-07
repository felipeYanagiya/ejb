package br.com.dextra.treinamento.model.service.timer;

import javax.ejb.Local;

@Local
public interface TestTimer {

    public void createSchedule(Long begin, Long finish);
    
    public void cancelSchedule();
    
}
