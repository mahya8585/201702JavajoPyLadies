package com.javajo.azure.example.controller;


import com.javajo.azure.example.dto.computerVision.AnalyzeImage;
import com.javajo.azure.example.service.AdultJudgmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * その写真が卑猥か否かを判定する処理
 * <b>Azure Cognitive Service利用</b>
 * Created by 4605851 on 2017/01/31.
 */
@Controller
@RequestMapping("/adult")
@Slf4j
public class AdultJudgmentController {
    @Autowired
    private AdultJudgmentService adultJudgmentService;

    /**
     * アダルト写真判定処理
     *
     * @param targetUrl
     * @param model
     * @return
     */
    @RequestMapping(value = "/judgment", method = RequestMethod.POST)
    public String judgeAdult(@RequestParam String targetUrl, Model model) {
        //Azure Comuputer Visionはファイルサイズが4MBまでなので、ファイルサイズのチェック処理を追加するべき(本来なら)
        //拡張子チェックなどのバリデーションも作成する必要あり(本来なら)

        try {
            //画像URLからComputer Vision結果を取得する
            AnalyzeImage adultDetection = adultJudgmentService.detectAdult(targetUrl);

            //取得結果の整形
            model = adultJudgmentService.makeResultModel(model, adultDetection, targetUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //表示
        return display(model);
    }

    /**
     * 処理結果表示
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/display")
    public String display(Model model) {
        log.debug("結果表示API");

        return "resultAdultJudgment";
    }
}
