package misc;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class SolutionGSHackathon {


	static Map<Integer, Order> orderBook = new TreeMap<Integer, Order>();
	static Map<String, PriorityQueue<Order>> buyBook = new HashMap<String, PriorityQueue<Order>>();
	static Map<String, PriorityQueue<Order>> sellBook = new HashMap<String, PriorityQueue<Order>>();
	
	static class Order{
		private char action;
		private int orderID;
		private int timestamp;
		private String symbol;
		private char orderType;
		private char side;
		private float price;
		private int quantity;
		
		@Override
		public String toString() {
			return "Order [action=" + action + ", orderID=" + orderID + ", timestamp=" + timestamp + ", symbol="
					+ symbol + ", orderType=" + orderType + ", side=" + side + ", price=" + price + ", quantity="
					+ quantity + "]";
		}

		public Order(String[] params) {
			this.action = params[0].charAt(0);
			this.orderID = Integer.parseInt(params[1]);
			this.timestamp = Integer.parseInt(params[2]);
			if(params.length > 3) {
				this.symbol = params[3];
				this.orderType = params[4].charAt(0);
				this.side = params[5].charAt(0);
				this.price = Float.valueOf(params[6]);
				this.quantity = Integer.parseInt(params[7]);
			}
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + action;
			result = prime * result + orderID;
			result = prime * result + orderType;
			result = prime * result + Float.floatToIntBits(price);
			result = prime * result + quantity;
			result = prime * result + side;
			result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
			result = prime * result + timestamp;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Order other = (Order) obj;
			if (action != other.action)
				return false;
			if (orderID != other.orderID)
				return false;
			if (orderType != other.orderType)
				return false;
			if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
				return false;
			if (quantity != other.quantity)
				return false;
			if (side != other.side)
				return false;
			if (symbol == null) {
				if (other.symbol != null)
					return false;
			} else if (!symbol.equals(other.symbol))
				return false;
			if (timestamp != other.timestamp)
				return false;
			return true;
		}

		public static final Comparator<Order> idComparator = new Comparator<Order>(){
			
			@Override
			public int compare(Order o1, Order o2) {
				int diff = (int) (o1.price - o2.price);
				if(diff == 0) {
					diff = o1.timestamp - o2.timestamp;
				}
					
	            return diff;
	        }
		};
	}
	
	
    static String[] processQueries(String[] queries) {
    	List<String> result = new ArrayList<String>();	
    	for(String query : queries) {
    		char act = query.charAt(0);
    		String[] params = query.split(",");
    		switch(act) {
    		
    		case 'N':
    			result.add(addOrder(params));
    			break;
    		case 'A':
    			result.add(amendOrder(params));
    			break;
    		case 'X':
    			result.add(cancelOrder(params));
    			break;
    		case 'M':
    			result.addAll(matchOrders(params));
    			break;
    		case 'Q':
    			result.addAll(queryOrders(params));
    			break;

    		}
    	}
        
        String[] output = new String[result.size()];
        
        for(int i = 0; i < result.size(); i++){
            output[i] = result.get(i);
        }
        
		return output;
    }


    private static List<String> queryOrders(String[] params) {
		List<String> matchedResults = new ArrayList<String>();
		return matchedResults;
	}


	private static List<String> matchOrders(String[] params) {
		List<String> matchedResults = new ArrayList<String>();
		for(Map.Entry<String, PriorityQueue<Order>> entry : buyBook.entrySet()) {
			
			String symbol = entry.getKey();
			PriorityQueue<Order> orders = entry.getValue();
			Iterator<Order> itr = orders.iterator();
			while(itr.hasNext()) {
			
				matchedResults.add(itr.next().toString());
				
				
			}
			
		}
		return matchedResults;
	}


	private static String cancelOrder(String[] params) {
		
		try {
			Order cancelOrder = new Order(params);
			if(!orderBook.containsKey(cancelOrder.orderID)) {
				return cancelOrder.orderID + "– CancelReject - 404 - Order does not exist";
			} else {
				Order canceledOrder = orderBook.get(cancelOrder.orderID);
				orderBook.remove(cancelOrder.orderID);
				if('B' == canceledOrder.side) {
					removeElementFromQueue(canceledOrder, buyBook);
				} else if('C' == canceledOrder.side) {
					removeElementFromQueue(canceledOrder, sellBook);
				}
				return cancelOrder.orderID + "– CancelAccept";
			}
			
		} catch (Exception e) {
			return Integer.parseInt(params[1]) + "– CancelReject - 404 - Order does not exist";
		}
		
		
		
	}


	private static String amendOrder(String[] params) {
		try {
			Order amendOrder = new Order(params);
			Order existingOrder = orderBook.get(amendOrder.orderID);
			
			if(existingOrder == null) {
				return amendOrder.orderID + "- AmendReject - 404 - Object does not exist";
			}
			
			System.out.println(amendOrder);
			System.out.println(existingOrder);
			
			if(!existingOrder.symbol.equals(amendOrder.symbol) || existingOrder.orderType != amendOrder.orderType || existingOrder.side != amendOrder.side) {
				return existingOrder.orderID + "- AmendReject - 101 - Invalid amendment details";
			} else {
				orderBook.put(amendOrder.orderID, amendOrder);
				
				if('B' == amendOrder.side) {
					removeElementFromQueue(existingOrder, buyBook);
					addElementToQueue(amendOrder, buyBook);
				} else if('C' == amendOrder.side) {
					removeElementFromQueue(existingOrder, sellBook);
					addElementToQueue(amendOrder, sellBook);
				}
				
				return amendOrder.orderID + "- AmendAccept";
			}
		} catch (Exception e) {
			return Integer.parseInt(params[1]) + "- AmendReject - 101 - Invalid amendment details";
		}
	}


	private static String addOrder(String[] params) {
		
		try {
			Order newOrder = new Order(params);
			
			if(!orderBook.containsKey(newOrder.orderID)) {
				orderBook.put(newOrder.orderID, newOrder);
				if('B' == newOrder.side) {
					addElementToQueue(newOrder, buyBook);
				} else if('C' == newOrder.side) {
					addElementToQueue(newOrder, sellBook);
				}
				return newOrder.orderID + "- Accept";
			}
			else {
				return newOrder.orderID + "- Reject - 303 - Invalid order details";
			}
		} catch (Exception e) {
			return Integer.parseInt(params[1]) + "- Reject - 303 - Invalid order details";
		}		
	}


	private static void addElementToQueue(Order amendOrder, Map<String, PriorityQueue<Order>> book) {
		String symbol = amendOrder.symbol;
		if(!book.containsKey(symbol))
			book.put(symbol, new PriorityQueue<Order>());
		book.get(symbol).add(amendOrder);
	}


	private static void removeElementFromQueue(Order existingOrder, Map<String, PriorityQueue<Order>> book) {
		PriorityQueue<Order> orderQueue = book.get(existingOrder.symbol);
		for(Order ord : orderQueue) {
			if(ord.equals(existingOrder))
				orderQueue.remove(ord);
		}
	}

	private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        if (bw == null) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int queriesSize = Integer.parseInt(scan.nextLine().trim());

        String[] queries = new String[queriesSize];

        for (int queriesItr = 0; queriesItr < queriesSize; queriesItr++) {
            String queriesItem = scan.nextLine();
            queries[queriesItr] = queriesItem;

        }

        String[] response = processQueries(queries);

        for (int responseItr = 0; responseItr < response.length; responseItr++) {
            bw.write(response[responseItr]);

            if (responseItr != response.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}
