package com.fantasybaby.common.module.player.request;

import com.fantasybaby.common.core.serial.Serializer;

/**
 * 登录请求
 * @author fantasybaby
 *
 */
public class LoginRequest extends Serializer{
	
	/**
	 * 用户名
	 */
	private String playerName;
	
	/**
	 * 密码
	 */
	private String password;

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	protected void read() {
		this.playerName = readString();
		this.password = readString();
	}

	@Override
	protected void write() {
		writeString(playerName);
		writeString(password);
	}
}
