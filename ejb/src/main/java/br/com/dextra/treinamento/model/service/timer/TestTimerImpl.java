package br.com.dextra.treinamento.model.service.timer;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import br.com.dextra.treinamento.model.domain.Post;
import br.com.dextra.treinamento.model.service.jpa.PostService;

@Stateless
public class TestTimerImpl implements TestTimer {

    @Resource
    private SessionContext ctx;

    private String schedulingName = "ListarPostsTimer";

    @EJB
    private PostService postService;

    public void createSchedule(Long begin, Long finish) {
	TimerService ts = ctx.getTimerService();
	ts.createTimer(begin, finish, schedulingName);
    }

    public void cancelSchedule() {

	@SuppressWarnings("unchecked")
	Collection<Timer> timers = ctx.getTimerService().getTimers();
	for (Timer timer : timers) {
	    if (timer.getInfo().equals(schedulingName)) {
		timer.cancel();
	    }
	}

    }

    @Timeout
    public void execute(Timer timer) {
	// quantidade de posts
	List<Post> posts = postService.listar();
	System.out.println("Quantidade de posts:" + posts.size());
    }

}
