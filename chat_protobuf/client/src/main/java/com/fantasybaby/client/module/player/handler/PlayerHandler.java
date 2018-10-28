package com.fantasybaby.client.module.player.handler;
import com.fantasybaby.common.core.annotion.SocketCommand;
import com.fantasybaby.common.core.annotion.SocketModule;
import com.fantasybaby.common.module.ModuleId;
import com.fantasybaby.common.module.player.PlayerCmd;
/**
 * 玩家模块
 * @author fantasybaby
 *
 */
@SocketModule(module = ModuleId.PLAYER)
public interface PlayerHandler {
	
	
	/**
	 * 创建并登录帐号
	 * @param resultCode
	 * @param data {@link null}
	 */
	@SocketCommand(cmd = PlayerCmd.REGISTER_AND_LOGIN)
	public void registerAndLogin(int resultCode, byte[] data);
	

	/**
	 * 创建并登录帐号
	 * @param resultCode
	 * @param data {@link null}
	 */
	@SocketCommand(cmd = PlayerCmd.LOGIN)
	public void login(int resultCode, byte[] data);

}
