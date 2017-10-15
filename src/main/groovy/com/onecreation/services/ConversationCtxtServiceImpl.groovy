package com.onecreation.services

import com.onecreation.models.ConversationContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class ConversationCtxtServiceImpl implements ConversationCtxtService {

    private RedisTemplate<String, ConversationContext> redisTemplate

    @Autowired
    ConversationCtxtServiceImpl(RedisTemplate<String, ConversationContext> redisTemplate) {
        this.redisTemplate = redisTemplate
    }

    @Override
    void saveConversation(String id, ConversationContext ctxt) {
        redisTemplate.opsForList().rightPush(id, ctxt)
    }

    @Override
    ConversationContext find(String id) {
        return redisTemplate.opsForList().rightPop(id)
    }

    @Override
    void delete(String id) {
        redisTemplate.opsForList().rightPop(id)
    }

    @Override
    boolean isConversationsAvailable(String id) {
        redisTemplate.opsForList().size(id)
    }
}
