  static class People{
        String name;
        int mark;

        public People(String name, int mark) {
            this.name = name;
            this.mark = mark;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            List<People> list = new ArrayList<People>() ;

            int num = in.nextInt();
            int flag = in.nextInt();

            for (int i = 0; i < num; i++) {
                String a = in.next();
                int b = in.nextInt();
                People people = new People(a,b);
                list.add(people);
            }
            Collections.sort(list, new Comparator<People>() {
                @Override
                public int compare(People o1, People o2) {
                    if(flag == 0){
                        return  o2.mark-o1.mark;
                    }else {
                        return o1.mark-o2.mark;
                    }
                }
            });

            for (People people : list) {
                System.out.println(people.name+" "+people.mark);
            }
        }

    }