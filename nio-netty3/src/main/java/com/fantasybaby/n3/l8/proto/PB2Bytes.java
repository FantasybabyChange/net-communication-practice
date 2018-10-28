package com.fantasybaby.n3.l8.proto;


import java.util.Arrays;
/**
 * protobuf学习
 * @author -fantasybaby-
 *
 */
public class PB2Bytes {

	public static void main(String[] args) throws Exception {
		byte[] bytes = toBytes();
		toPlayer(bytes);

	}

	/**
	 * 序列化
	 */
	public static byte[] toBytes(){
		//获取一个PBPlayer的构造器
		PlayerModule.PBPlayer.Builder builder = PlayerModule.PBPlayer.newBuilder();
		//设置数据
		builder.setPlayerId(101).setAge(20).setName("peter").addSkills(1001);
		//构造出对象
		PlayerModule.PBPlayer player = builder.build();
		//序列化成字节数组
		byte[] byteArray = player.toByteArray();
		
		System.out.println(Arrays.toString(byteArray));
		
		return byteArray;
	}
	
	/**
	 * 反序列化
	 * @param bs
	 * @throws Exception 
	 */
	public static void toPlayer(byte[] bs) throws Exception{
		
		 PlayerModule.PBPlayer player = PlayerModule.PBPlayer.parseFrom(bs);
		 
		 System.out.println("playerId:" + player.getPlayerId());
		 System.out.println("age:" + player.getAge());
		 System.out.println("name:" + player.getName());
		 System.out.println("skills:" + (Arrays.toString(player.getSkillsList().toArray())));
	}
}
