package org.knowm.xchange.poloniex.service.marketdata;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.poloniex.PoloniexExchange;
import org.knowm.xchange.service.polling.marketdata.PollingMarketDataService;

/**
 * @author timmolter
 */
public class TickerFetchIntegration {

  @Test
  public void tickerFetchTest() throws Exception {

    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(PoloniexExchange.class.getName());
    exchange.remoteInit();
    PollingMarketDataService marketDataService = exchange.getPollingMarketDataService();
    CurrencyPair currencyPair = exchange.getExchangeMetaData().getCurrencyPairs().keySet().iterator().next();
    Ticker ticker = marketDataService.getTicker(currencyPair);
    System.out.println(ticker.toString());
    assertThat(ticker).isNotNull();
  }

}
