package cal.zemoga.CALZemogaTest.services;

import cal.zemoga.CALZemogaTest.entity.Portfolio;
import cal.zemoga.CALZemogaTest.repository.RepositoryPortfolio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServicePortfolioImplTest {

    @InjectMocks
    private ServicePortfolioImpl servicePortfolio;

    @Mock
    private RepositoryPortfolio repositoryPortfolio;

    @Before
    public void init(){
        servicePortfolio = new ServicePortfolioImpl(repositoryPortfolio);
    }

    @Test
    public void whenPortfolioExistsThenOk(){
        Portfolio portfolio = null;
        Integer idPortfolio = 115;

        when(servicePortfolio.portfolioSearch(anyInt())).thenReturn(new Portfolio());
        portfolio = servicePortfolio.portfolioSearch(idPortfolio);

        Assert.assertNotNull(portfolio);
    }

    @Test
    public void whenPortfolioNotExistsThenNull(){
        Portfolio portfolio = null;
        Integer idPortfolio = -1;

        when(servicePortfolio.portfolioSearch(-1)).thenReturn(null);
        portfolio = servicePortfolio.portfolioSearch(idPortfolio);

        Assert.assertNull(portfolio);
    }

    @Test
    public void whenUpdatePortfolioExistsThenOk(){
        Portfolio portfolio = null;

        when(servicePortfolio.updatePortfolio(any(Portfolio.class))).thenReturn(new Portfolio());

        portfolio = servicePortfolio.updatePortfolio(new Portfolio());

        Assert.assertNotNull(portfolio);
    }

    @Test
    public void whenUpdatePortfolioNotExistsThenNull(){
        Portfolio portfolio = null;

        when(servicePortfolio.updatePortfolio(any(Portfolio.class))).thenReturn(null);

        portfolio = servicePortfolio.updatePortfolio(new Portfolio());

        Assert.assertNull(portfolio);
    }
}
