package cal.zemoga.CALZemogaTest.services;

import cal.zemoga.CALZemogaTest.entity.Portfolio;
import cal.zemoga.CALZemogaTest.repository.RepositoryPortfolio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.FieldSetter;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServicePortfolioImplTest {


    @Mock
    private RepositoryPortfolio repositoryPortfolio;

    @InjectMocks
    private ServicePortfolioImpl servicePortfolio = new ServicePortfolioImpl(repositoryPortfolio);


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenPortfolioExistsThenOk() throws NoSuchFieldException {
        Portfolio portfolio = null;
        Integer idPortfolio = 115;
        repositoryPortfolio = Mockito.mock(RepositoryPortfolio.class);
        FieldSetter.setField(servicePortfolio,servicePortfolio
                .getClass()
                .getDeclaredField("repositoryPortfolio"), repositoryPortfolio);

        when(repositoryPortfolio.findById(anyInt())).thenReturn(Optional.of(new Portfolio()));
        portfolio = servicePortfolio.portfolioSearch(idPortfolio);

        Assert.assertNotNull(portfolio);
    }

    @Test
    public void whenPortfolioNotExistsThenNull() throws NoSuchFieldException {
        Portfolio portfolio = null;
        Integer idPortfolio = -1;
        repositoryPortfolio = Mockito.mock(RepositoryPortfolio.class);
        FieldSetter.setField(servicePortfolio,servicePortfolio
                .getClass()
                .getDeclaredField("repositoryPortfolio"), repositoryPortfolio);

        when(repositoryPortfolio.findById(anyInt())).thenReturn(Optional.empty());
        portfolio = servicePortfolio.portfolioSearch(idPortfolio);

        Assert.assertNull(portfolio);
    }

    @Test
    public void whenUpdatePortfolioExistsThenOk() throws NoSuchFieldException {
        Portfolio portfolio = null;
        repositoryPortfolio = Mockito.mock(RepositoryPortfolio.class);

        FieldSetter.setField(servicePortfolio,servicePortfolio
                .getClass()
                .getDeclaredField("repositoryPortfolio"), repositoryPortfolio);

        when(repositoryPortfolio.findById(anyInt())).thenReturn(Optional.of(new Portfolio()));
        servicePortfolio = Mockito.mock(ServicePortfolioImpl.class);
        doReturn(new Portfolio()).when(servicePortfolio).portfolioSearch(anyInt());
        when(repositoryPortfolio.save(any(Portfolio.class))).thenReturn(new Portfolio());
        when(servicePortfolio.updatePortfolio(any(Portfolio.class))).thenReturn(new Portfolio());

        portfolio = servicePortfolio.updatePortfolio(new Portfolio());

        Assert.assertNotNull(portfolio);
    }

    @Test
    public void whenUpdatePortfolioNotExistsThenNull() throws NoSuchFieldException {
        Portfolio portfolio = null;
        repositoryPortfolio = Mockito.mock(RepositoryPortfolio.class);

        FieldSetter.setField(servicePortfolio,servicePortfolio
                .getClass()
                .getDeclaredField("repositoryPortfolio"), repositoryPortfolio);

        when(repositoryPortfolio.findById(anyInt())).thenReturn(Optional.of(new Portfolio()));
        servicePortfolio = Mockito.mock(ServicePortfolioImpl.class);
        doReturn(new Portfolio()).when(servicePortfolio).portfolioSearch(anyInt());
        when(repositoryPortfolio.save(any(Portfolio.class))).thenReturn(new Portfolio());
        when(servicePortfolio.updatePortfolio(any(Portfolio.class))).thenReturn(null);

        portfolio = servicePortfolio.updatePortfolio(new Portfolio());

        Assert.assertNull(portfolio);
    }
}
