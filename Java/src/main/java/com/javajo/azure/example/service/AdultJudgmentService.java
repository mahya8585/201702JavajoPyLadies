package com.javajo.azure.example.service;

import com.javajo.azure.example.dto.AzureDisplay;
import com.javajo.azure.example.dto.computerVision.Adult;
import com.javajo.azure.example.dto.computerVision.AnalyzeImage;
import com.javajo.azure.example.helper.AzureComputerVisionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * アダルト判定サービスクラス
 * Created by 4605851 on 2017/02/03.
 */
@Component
public class AdultJudgmentService {
    @Autowired
    private AzureComputerVisionHelper azureComputerVisionHelper;

    /**
     * アダルト検知処理を行う
     *
     * @param targetImageUrl
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public AnalyzeImage detectAdult(String targetImageUrl) throws IOException, URISyntaxException {
        List<AzureComputerVisionHelper.VisualFeature> visualFeatures = new ArrayList<>();
        //TODO 実行したいVisualFeatureタイプをListで設定してください

        //TODO azureComputerVisionHelper.analyzeImageメソッドを呼び出し、analyzeImageメソッドの返却値をreturnしてください
        // 今はエラーが出ないように空のAnalyzeImageを返却していますが、このコードは削除してかまいません。↑の処理をreturnしてください
        return new AnalyzeImage();
    }

    /**
     * 処理結果を表示用モデルに設定する
     *
     * @param model
     * @param analyzeResult
     * @param imgUrl
     * @return
     */
    public Model makeResultModel(Model model, AnalyzeImage analyzeResult, String imgUrl) {
        AzureDisplay responseAzureDisplay = new AzureDisplay();
        responseAzureDisplay.setImgUrl(imgUrl);

        Adult analyzeAdultInfo = analyzeResult.getAdult();
        responseAzureDisplay.setAdultScore(analyzeAdultInfo.getAdultScore());
        responseAzureDisplay.setRacyScore(analyzeAdultInfo.getRacyScore());

        //解析結果の判定
        //精緻にやりたい場合はスコアから判定するべし
        responseAzureDisplay.setResult(makeResultStr(analyzeAdultInfo.getIsAdultContent(), analyzeAdultInfo.getIsRacyContent()));

        model.addAttribute("display", responseAzureDisplay);
        return model;
    }


    /**
     * 表示する結果文言の作成
     *
     * @param isAdult
     * @param isRacy
     * @return
     */
    private String makeResultStr(boolean isAdult, boolean isRacy) {
        if (isAdult) {
            return "この画像は18禁です! 見ちゃダメ!";

        } else if (isRacy) {
            return "この画像はきわどい写真です! 気を付けて!";

        } else {
            return "この画像は健全な写真です。";
        }
    }

}
