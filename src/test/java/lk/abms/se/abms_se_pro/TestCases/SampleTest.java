package lk.abms.se.abms_se_pro.TestCases;

import lk.abms.se.abms_se_pro.bussiness.WorkerManageService;
import lk.abms.se.abms_se_pro.dao.WorkerRepository;
import lk.abms.se.abms_se_pro.entity.Worker;
import lk.abms.se.abms_se_pro.model.WorkerDTO;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class SampleTest {

    WorkerManageService w = Mockito.mock(WorkerManageService.class);


    @Test
    public void findWorkers() throws Exception {
        List<WorkerDTO> allWorkers = w.findAllWorkers();
        System.out.println(allWorkers);
        int index = (allWorkers.size() > 0) ? 1 : 0;
        Assert.assertEquals(1, index);
    }

    WorkerRepository repository  =Mockito.mock(WorkerRepository.class);

    @Test
    public void find(){

        Worker worker = repository.findByWorkerId("WRNO01");
        Assert.assertEquals("WRNO01",worker.getWorkerId());

    }



}
