package ru.practicum.ewm.handler;

import ru.practicum.ewm.stats.avro.EventSimilarityAvro;

public interface EventSimilarityHandler {
    void handleEventSimilarity(EventSimilarityAvro eventSimilarityAvro);
}