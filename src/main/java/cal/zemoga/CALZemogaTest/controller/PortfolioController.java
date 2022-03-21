package cal.zemoga.CALZemogaTest.controller;

import cal.zemoga.CALZemogaTest.entity.Portfolio;
import cal.zemoga.CALZemogaTest.services.ServicePortfolio;
import cal.zemoga.CALZemogaTest.services.ServiceTwitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/portfolios")
public class PortfolioController {

    @Autowired
    private ServicePortfolio servicePortfolio;

    @Autowired
    private ServiceTwitter serviceTwitter;


    @GetMapping(value = "/{portfolioId}")
    public ResponseEntity<Portfolio> getPortfolio(@PathVariable("portfolioId") Integer portfolioId){
        Portfolio searched = servicePortfolio.portfolioSearch(portfolioId);

        if(searched == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(searched);
    }


    @PutMapping(value = "/{portfolioId}")
    public ResponseEntity<Portfolio> updatePorfolio(@PathVariable(value = "portfolioId") Integer portfolioId,
                                                    @RequestBody Portfolio portfolio){
        portfolio.setId(portfolioId);
        Portfolio updated = servicePortfolio.updatePortfolio(portfolio);
        if (updated == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

}
