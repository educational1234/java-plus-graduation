package ru.practicum.client;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;
import ru.practicum.ewm.stats.messages.InteractionsCountRequestProto;
import ru.practicum.ewm.stats.messages.RecommendedEventProto;
import ru.practicum.ewm.stats.messages.SimilarEventsRequestProto;
import ru.practicum.ewm.stats.messages.UserPredictionsRequestProto;
import ru.practicum.ewm.stats.services.RecommendationsControllerGrpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class AnalyzerClient {
    @GrpcClient("analyzer")
    private RecommendationsControllerGrpc.RecommendationsControllerBlockingStub analyzerClient;

    public List<RecommendedEventProto> getRecommendations(Long userId, Integer maxResults) {
        UserPredictionsRequestProto request = UserPredictionsRequestProto.newBuilder()
                .setUserId(userId)
                .setMaxResults(maxResults)
                .build();
        log.info("Запрос на получение рекомендаций: {}", request);
        List<RecommendedEventProto> result = new ArrayList<>();
        analyzerClient.getRecommendationsForUser(request)
                .forEachRemaining(result::add);
        log.info("Резйльтат получения рекомендаций: {}", result);
        return result;
    }

    public List<RecommendedEventProto> getSimilarEvents(Long eventId, Long userId, Integer maxResults) {
        SimilarEventsRequestProto request = SimilarEventsRequestProto.newBuilder()
                .setEventId(eventId)
                .setUserId(userId)
                .setMaxResults(maxResults)
                .build();
        log.info("Запрос на получение похожих мероприятий для указанного: {}", request);
        List<RecommendedEventProto> result = new ArrayList<>();
        analyzerClient.getSimilarEvents(request)
                .forEachRemaining(result::add);
        log.info("Результат получения похожих мероприятий для указанного: {}", request);
        return result;
    }

    public Map<Long, Double> getInteractionsCount(List<Long> eventIds) {
        InteractionsCountRequestProto request = InteractionsCountRequestProto.newBuilder()
                .addAllEventId(eventIds)
                .build();
        log.info("Запрос на получение суммы весов для каждого события: {}", request);
        Map<Long, Double> result = new HashMap<>();
        analyzerClient.getInteractionsCount(request)
                .forEachRemaining(e -> result.put(e.getEventId(), e.getScore()));
        log.info("Результат получения суммы весов для каждого события: {}", request);
        return result;
    }
}