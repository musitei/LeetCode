 class LRUCache extends LinkedHashMap<Integer,Integer>{
        private int capacity;
        public LRUCache(int capacity){
            super(capacity,0.75F,true);
            //根据指定容量、装载因子和键值对保持顺序创建一个LinkedHashMap
            this.capacity=capacity;
        }
        public int get(int key){
            return super.getOrDefault(key,-1);

        }
        public void put(int key,int value){
            super.put(key,value);
        }
        protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
            return size()>capacity;
            //判断是否大于容量 返回一个布尔值
            
        }
    }