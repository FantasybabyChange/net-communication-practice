package com.fantasybaby.n3.l10.common.module.fuben.request;

import com.fantasybaby.n3.l10.common.serial.Serializer;

public class FightRequest extends Serializer {
	
	/**
	 * 副本id
	 */
	private int fubenId;
	
	/**
	 * 次数
	 */
	private int count;

	public int getFubenId() {
		return fubenId;
	}

	public void setFubenId(int fubenId) {
		this.fubenId = fubenId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	protected void read() {
		this.fubenId = readInt();
		this.count = readInt();
	}

	@Override
	protected void write() {
		writeInt(fubenId);
		writeInt(count);
	}
	
	

}
