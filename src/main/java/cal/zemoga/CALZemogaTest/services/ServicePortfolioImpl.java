package cal.zemoga.CALZemogaTest.services;

import cal.zemoga.CALZemogaTest.entity.Portfolio;
import cal.zemoga.CALZemogaTest.repository.RepositoryPortfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@Service
public class ServicePortfolioImpl implements ServicePortfolio{

    private final RepositoryPortfolio repositoryPortfolio;


    @Override
    public Portfolio portfolioSearch(Integer id) {
        return repositoryPortfolio.findById(id).orElse(null);
    }


    @Override
    public Portfolio updatePortfolio(Portfolio portfolio) {
        Portfolio searched = portfolioSearch(portfolio.getIdportfolio());
        if (searched == null) {
            return null;
        }
        searched.setAddress(portfolio.getAddress());
        searched.setDescription(portfolio.getDescription());
        searched.setExperience(portfolio.getExperience());
        searched.setPhone(portfolio.getPhone());
        return repositoryPortfolio.save(searched);

    }

}
