package com.fantasybaby.server.module.player.handler;

import com.fantasybaby.common.core.annotion.SocketCommand;
import com.fantasybaby.common.core.annotion.SocketModule;
import com.fantasybaby.common.core.model.Result;
import com.fantasybaby.common.core.session.Session;
import com.fantasybaby.common.module.ModuleId;
import com.fantasybaby.common.module.player.PlayerCmd;
import com.fantasybaby.common.module.player.proto.PlayerModule.LoginRequest;
import com.fantasybaby.common.module.player.proto.PlayerModule.PlayerResponse;
import com.fantasybaby.common.module.player.proto.PlayerModule.RegisterRequest;
/**
 * 玩家模块
 * @author fantasybaby
 *
 */
@SocketModule(module = ModuleId.PLAYER)
public interface PlayerHandler {
	
	
	/**
	 * 创建并登录帐号
	 * @param session
	 * @param data {@link RegisterRequest}
	 * @return
	 */
	@SocketCommand(cmd = PlayerCmd.REGISTER_AND_LOGIN)
	public Result<PlayerResponse> registerAndLogin(Session session, byte[] data);
	

	/**
	 * 登录帐号
	 * @param session
	 * @param data {@link LoginRequest}
	 * @return
	 */
	@SocketCommand(cmd = PlayerCmd.LOGIN)
	public Result<PlayerResponse> login(Session session, byte[] data);

}
