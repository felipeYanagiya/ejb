package br.com.dextra.treinamento.controller.bean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import br.com.dextra.treinamento.model.service.timer.TestTimer;

@ManagedBean(name = "testarTimerMB")
@RequestScoped
public class TestarTimerMB {

    @EJB
    private TestTimer testTimer;

    public void schedule() {
	Long interval = 30*1000L;
	testTimer.createSchedule(interval, interval);
    }

    public void cancelSchedule() {
	testTimer.cancelSchedule();
	System.out.println("***Timer cancelado!***");
    }

}
