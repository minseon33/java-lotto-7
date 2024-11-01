package lotto.controller;

import java.util.List;
import lotto.controller.view.InputView;
import lotto.controller.view.OutputView;
import lotto.controller.view.Validator;
import lotto.domain.GameManager;
import lotto.domain.Lotteries;
import lotto.domain.LottoGameManager;

public class LottoController {
    private final Policy policy;
    private final InputView inputView;
    private final OutputView outputView;
    private final GameManager gameManager;

    private LottoController(Policy policy, InputView inputView, OutputView outputView,GameManager gameManager) {
        this.policy = policy;
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameManager = gameManager;
    }

    public static LottoController newDefaultInstance(Policy policy){
        return new LottoController(policy, new InputView(Validator.newInstance(policy)), new OutputView(),new LottoGameManager());
    }

    public void run(){
        // 구입금액 받기
        int inputAmount = inputView.inputAmount();
        // 로또 객체 생성
        int buyCount = gameManager.calculateBuyCount(inputAmount, policy.getAmountPolicy());
        Lotteries lotteries = gameManager.initLottery(policy, buyCount);
        // 생성한 로또 객체 출력
        outputView.printLotteries(buyCount,lotteries);
        // 당첨번호 받기
        List<Integer> integers = inputView.inputWinningNumber();
        //보너스 번호 받기
        int bonusNumber = inputView.inputBonusNumber(integers);
        // 로또 추첨
        // 통계 출력
    }


}
