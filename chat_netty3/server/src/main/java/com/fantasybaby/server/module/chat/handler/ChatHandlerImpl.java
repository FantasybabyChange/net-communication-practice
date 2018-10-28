package com.fantasybaby.server.module.chat.handler;

import com.fantasybaby.server.module.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fantasybaby.common.core.exception.ErrorCodeException;
import com.fantasybaby.common.core.model.Result;
import com.fantasybaby.common.core.model.ResultCode;
import com.fantasybaby.common.module.chat.request.PrivateChatRequest;
import com.fantasybaby.common.module.chat.request.PublicChatRequest;

@Component
public class ChatHandlerImpl implements ChatHandler{
	
	@Autowired
	private ChatService chatService;

	@Override
	public Result<?> publicChat(long playerId, byte[] data) {
		System.out.println(" ChatHandlerImplThread Name:"+Thread.currentThread().getName());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			//反序列化
			PublicChatRequest request = new PublicChatRequest();
			request.readFromBytes(data);
			
			//参数校验
			if(StringUtils.isEmpty(request.getContext())){
				return Result.ERROR(ResultCode.AGRUMENT_ERROR);
			}
			
			//执行业务
			chatService.publicChat(playerId, request.getContext());
		} catch (ErrorCodeException e) {
			return Result.ERROR(e.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
			return Result.ERROR(ResultCode.UNKOWN_EXCEPTION);
		}
		return Result.SUCCESS();
	}

	@Override
	public Result<?> privateChat(long playerId, byte[] data) {
		try {
			//反序列化
			PrivateChatRequest request = new PrivateChatRequest();
			request.readFromBytes(data);
			
			//参数校验
			if(StringUtils.isEmpty(request.getContext()) || request.getTargetPlayerId() <= 0){
				return Result.ERROR(ResultCode.AGRUMENT_ERROR);
			}
			
			//执行业务
			chatService.privateChat(playerId, request.getTargetPlayerId(), request.getContext());
		} catch (ErrorCodeException e) {
			return Result.ERROR(e.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
			return Result.ERROR(ResultCode.UNKOWN_EXCEPTION);
		}
		return Result.SUCCESS();
	}
}
