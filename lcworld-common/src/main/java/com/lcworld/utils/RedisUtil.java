package com.lcworld.utils;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPipeline;
import redis.clients.jedis.ShardedJedisPool;

@Service
public class RedisUtil {

    @Autowired(required = false)//运行的Spring环境中如果存在就注入，没有就忽略
    private ShardedJedisPool shardedJedisPool;

    private <T> T execute(Function<T, ShardedJedis> fun) {
        ShardedJedis shardedJedis = null;
        try {
            // 从连接池中获取到jedis分片对象
            shardedJedis = shardedJedisPool.getResource();
            return fun.callback(shardedJedis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != shardedJedis) {
                // 关闭，检测连接是否有效，有效则放回到连接池中，无效则重置状态
                shardedJedis.close();
            }
        }
        return null;
    }

    /**
     * 执行set操作
     * 
     * @param key
     * @param value
     * @return
     */
    public String set(final String key, final String value) {
        return this.execute(new Function<String, ShardedJedis>() {
            @Override
            public String callback(ShardedJedis e) {
            	
                return e.set(key, value);
            }
        });
    }
    /**
     * 查询list数据的数量
     */
    public Long llen(final String key) {
        return this.execute(new Function<Long, ShardedJedis>() {
            @Override
            public Long callback(ShardedJedis e) {
                return e.llen(key);
            }
        });
    }
    /**
     * 返回指定范围内元素的列表。
     * Redis Lrange 返回列表中指定区间内的元素，区间以偏移量 START 和 END 指定。 其中 0 表示列表的第一个元素， 1 表示列表的第二个元素，以此类推。  
     * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。 
     * @param string 
     * @param key
     * @return
     */
 
    public List<String> lrange(final String key,final Long start,final Long end) {
        return this.execute(new Function<List<String>, ShardedJedis>() {
            @Override
            public List<String>  callback(ShardedJedis e) {
            	  return e.lrange(key, start, end);
            }
        });
    }
    /**
     * 返回被删除的元素数量,删除 对应count数量中，值为value的元素。
     * 从列表中从头部开始移除count个匹配的值。如果count为零，所有匹配的元素都被删除。如果count是负数，内容从尾部开始删除。
     */
    public Long lrem(final String key,final Long count,final String value) {
        return this.execute(new Function<Long, ShardedJedis>() {
            @Override
            public Long callback(ShardedJedis e) {
                return e.lrem(key, count, value);
            }
        });
    }
    
    /**
     * 保留指定范围内的元素
     */
    
    public String ltrim(final String key,final Long start,final Long end) {
        return this.execute(new Function<String, ShardedJedis>() {
            @Override
            public String callback(ShardedJedis e) {
                return e.ltrim(key, start, end);
            }
        });
    }
    
    /**
     * 执行事务操作
     * 
     * @param key
     * @param value
     * @return
     */
    public ShardedJedisPipeline start() {
    	return this.execute(new Function<ShardedJedisPipeline, ShardedJedis>() {
    		@Override
    		public ShardedJedisPipeline callback(ShardedJedis e) {
    			 ShardedJedisPipeline pipelined = e.pipelined();
    			
				return pipelined;
    			 
    		}
    	});
    }

    /**
     * 执行GET操作
     * 
     * @param key
     * @return
     */
    public String get(final String key) {
        return this.execute(new Function<String, ShardedJedis>() {
            @Override
            public String callback(ShardedJedis e) {
                return e.get(key);
            }
        });
    }

    /**
     * 执行DEL操作
     * 
     * @param key
     * @return
     */
    public Long del(final String key) {
        return this.execute(new Function<Long, ShardedJedis>() {
            @Override
            public Long callback(ShardedJedis e) {
                return e.del(key);
            }
        });
    }

    /**
     * 设置生存时间，单位为秒
     * 
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(final String key, final Integer seconds) {
        return this.execute(new Function<Long, ShardedJedis>() {
            @Override
            public Long callback(ShardedJedis e) {
                return e.expire(key, seconds);
            }
        });
    }

    /**
     * 执行set操作并且设置生存时间，单位为秒
     * 
     * @param key
     * @param value
     * @return
     */
    public String set(final String key, final String value, final Integer seconds) {
        return this.execute(new Function<String, ShardedJedis>() {
            @Override
            public String callback(ShardedJedis e) {
                String str = e.set(key, value);
                e.expire(key, seconds);
                return str;
            }
        });
    }
    
    
    
    
    
    /**
     * list操作 获取最左边一个元素并移除
     * 
     * @param key
     * @param value
     * @return
     */
    public String hmset(final String key,final Map<String, String> map) {
    	return this.execute(new Function<String, ShardedJedis>() {
    		@Override
    		public String callback(ShardedJedis e) {
    			String str = e.hmset(key,map);
    			return str;
    		}
    	});
    }
    /**
     * 往对应的map加值
     * @param key
     * @param map
     * @return
     */
    public Long hset(final String key,final String field,final String value) {
        return this.execute(new Function<Long, ShardedJedis>() {
            @Override
            public Long callback(ShardedJedis e) {
            	Long a = e.hset(key, field, value);
    			return a;
            }
        });
    }
    /**
     * 获取某个map的size
     * @param key
     * @param field
     * @param value
     * @return
     */
    public Long hlen(final String key) {
        return this.execute(new Function<Long, ShardedJedis>() {
            @Override
            public Long callback(ShardedJedis e) {
            	Long a = e.hlen(key);
    			return a;
            }
        });
    }
    
    /**
     * 从hash里面获取摸某一个值
     * 
     * @param key
     * @param value
     * @return
     */
    public String  hget(final String key,final String field) {
    	return this.execute(new Function<String, ShardedJedis>() {
    		@Override
    		public String callback(ShardedJedis e) {
    			String str = e.hget(key, field);
    			
    			return str;
    		}
    	});
    }
    
    
    /**
     * 从hash里面获取摸某一个值
     * 
     * @param key
     * @param value
     * @return
     */
    public Map<String, String>  hgetAll(final String key) {
    	return this.execute(new Function<Map<String, String>, ShardedJedis>() {
    		@Override
    		public Map<String, String> callback(ShardedJedis e) {
    			Map<String, String> str = e.hgetAll(key);
    			return str;
    		}
    	});
    }
    
    /**
     * 往list队列里尾部set值
     * 
     * @param key
     * @param value
     * @return
     */
    public Long  rpush(final String key,final String value) {
    	return this.execute(new Function<Long, ShardedJedis>() {
    		@Override
    		public Long callback(ShardedJedis e) {
    			
    			Long str = e.rpush(key, value);
    			return str;
    		}
    	});
    }
    
    /**
     * 往list队列里头部set值
     * 
     * @param key
     * @param value
     * @return
     */
    public Long  lpush(final String key,final String value) {
    	return this.execute(new Function<Long, ShardedJedis>() {
    		@Override
    		public Long callback(ShardedJedis e) {
    			
    			Long str = e.lpush(key, value);
    			return str;
    		}
    	});
    }
    
    
    /**
     * 往list队列里获取值
     * 
     * @param key
     * @param value
     * @return
     */
    public String  lpop(final String key) {
    	return this.execute(new Function<String, ShardedJedis>() {
    		@Override
    		public String callback(ShardedJedis e) {
    			
    			String str = e.lpop(key);
    			return str;
    		}
    	});
    }
    
    /**
     * 往list队列尾部里获取值
     * 
     * @param key
     * @param value
     * @return
     */
    public String  rpop(final String key) {
    	return this.execute(new Function<String, ShardedJedis>() {
    		@Override
    		public String callback(ShardedJedis e) {
    			
    			String str = e.rpop(key);
    			return str;
    		}
    	});
    }
    
    /**
     * 查看redis里存的对应字段，以确定现在能否工作
     * @param key
     * @return
     */
//    public synchronized boolean isWorking(String key){
//    	String num  =  get(key);
//    	if(num == null || Integer.parseInt(num)==0){
//    		//0空闲
//    		set(key,"1",30);
//    		return true;
//    	}else{
//    		//1忙碌
//    		return false;
//    	}
//    }
    public synchronized boolean isWorking(final String key){
    	return this.execute(new Function<Boolean, ShardedJedis>() {
    		@Override
    		public Boolean callback(ShardedJedis e) {
    			String num  =  e.get(key);
    	    	if(num == null || Integer.parseInt(num)==0){
    	    		//0空闲
    	    		e.setex(key, 30, "1");
    	    		return true;
    	    	}else{
    	    		//1忙碌
    	    		return false;
    	    	}
    		}
    	});
    }

  
 
  
    /** 
     * Redis Zadd 命令用于将一个或多个成员元素及其分数值加入到有序集当中。 
        如果某个成员已经是有序集的成员，那么更新这个成员的分数值，并通过重新插入这个成员元素，来保证该成员在正确的位置上。 
        分数值可以是整数值或双精度浮点数。 
        如果有序集合 key 不存在，则创建一个空的有序集并执行 ZADD 操作。 
        当 key 存在但不是有序集类型时，返回一个错误。 
     * @param string 
     * @param i 
     * @param string2 
     * @return 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。 
     */  
    public  Long zadd(final String key, final double score, final String member) {  
  /*      Jedis jedis = jedisPool.getResource();  
        Long result = jedis.zadd(key, score, member);  
        jedis.close();  
        return result;  
        */
    	return this.execute(new Function<Long, ShardedJedis>() {
    		@Override
    		public Long callback(ShardedJedis e) {
    			
    			Long str = e.zadd(key, score, member);
    			return str;
    		}
    	});
    }  
      
    /** 
     * Redis Zrevrangebyscore 返回有序集中指定分数区间内的所有的成员。有序集成员按分数值递减(从大到小)的次序排列。 
        具有相同分数值的成员按字典序的逆序(reverse lexicographical order )排列。 
        除了成员按分数值递减的次序排列这一点外， ZREVRANGEBYSCORE 命令的其他方面和 ZRANGEBYSCORE 命令一样。 
     * @param key 
     * @param max 
     * @param min 
     * @param offset 
     * @param count 
     * @return 指定区间内，带有分数值(可选)的有序集成员的列表。
     * 
     *  语法：zrevrangescore key max min [withscores] [limit offset count]

		解释：返回有续集key中score<=max并且score>=min 的元素，返回结果根据score从大到小顺序排列。可选参数withscores决定结果集中是否包含score，可选参数limit 指定返回结果集范围。
     */  
    	
    public  LinkedHashSet<String> zrevrangebyscore(final String key, final String max, final String min, final int offset, final int count) {  

    	return this.execute(new Function<LinkedHashSet<String>, ShardedJedis>() {
    		@Override
    		public LinkedHashSet<String> callback(ShardedJedis e) {
    			
    			
    			return (LinkedHashSet)e.zrevrangeByScore(key, max, min, offset, count); 
    		}
    	});
    }
    
    
    /**
     * 返回有续集key中指定范围【通过索引 start end】的member
     * @param key
     * @param start
     * @param 
     * @return
     */
    public  LinkedHashSet<String> zrange(final String key,final long start,final long end) {  

    	return this.execute(new Function<LinkedHashSet<String>, ShardedJedis>() {
    		@Override
    		public LinkedHashSet<String> callback(ShardedJedis e) {
    			
    			
    			return (LinkedHashSet)e.zrange(key,start, end);
    		}
    	});
    } 
    
    
    /**
     * 返回有续集key中指定范围[通过索引start stop]的member[及score]，返回member根据score按降序排列
     * @param key
     * @param start
     * @param end
     * @return
     * zrevrange score 0 -1 withscores  
     *  zrevrange score 1 -2  
     */
    public  LinkedHashSet<String> zrevrange(final String key,final long start,final long end) {  

    	return this.execute(new Function<LinkedHashSet<String>, ShardedJedis>() {
    		@Override
    		public LinkedHashSet<String> callback(ShardedJedis e) {
    			
    			
    			return (LinkedHashSet)e.zrevrange(key, start, end);
    			
    		}
    	});
    } 
    
}
