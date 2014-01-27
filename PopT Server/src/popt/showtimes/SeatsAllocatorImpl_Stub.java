// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package popt.showtimes;

public final class SeatsAllocatorImpl_Stub
    extends java.rmi.server.RemoteStub
    implements popt.rmi.SeatsAllocator, java.rmi.Remote
{
    private static final long serialVersionUID = 2;
    
    private static java.lang.reflect.Method $method_getComingShowtimesList_0;
    private static java.lang.reflect.Method $method_getTicketingStatus_1;
    private static java.lang.reflect.Method $method_searchAvailableSeats_2;
    private static java.lang.reflect.Method $method_searchAvailableSpecialSeats_3;
    private static java.lang.reflect.Method $method_sellSeat_4;
    private static java.lang.reflect.Method $method_sellSpecialSeat_5;
    
    static {
	try {
	    $method_getComingShowtimesList_0 = popt.rmi.SeatsAllocator.class.getMethod("getComingShowtimesList", new java.lang.Class[] {});
	    $method_getTicketingStatus_1 = popt.rmi.SeatsAllocator.class.getMethod("getTicketingStatus", new java.lang.Class[] {popt.data.Showtime.class});
	    $method_searchAvailableSeats_2 = popt.rmi.SeatsAllocator.class.getMethod("searchAvailableSeats", new java.lang.Class[] {popt.data.Showtime.class, int.class});
	    $method_searchAvailableSpecialSeats_3 = popt.rmi.SeatsAllocator.class.getMethod("searchAvailableSpecialSeats", new java.lang.Class[] {popt.data.Showtime.class, int.class});
	    $method_sellSeat_4 = popt.rmi.SeatsAllocator.class.getMethod("sellSeat", new java.lang.Class[] {popt.data.Showtime.class, popt.data.Seat[].class});
	    $method_sellSpecialSeat_5 = popt.rmi.SeatsAllocator.class.getMethod("sellSpecialSeat", new java.lang.Class[] {popt.data.Showtime.class, int.class});
	} catch (java.lang.NoSuchMethodException e) {
	    throw new java.lang.NoSuchMethodError(
		"stub class initialization failed");
	}
    }
    
    // constructors
    public SeatsAllocatorImpl_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of getComingShowtimesList()
    public java.util.LinkedList getComingShowtimesList()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getComingShowtimesList_0, null, -8827733520446949881L);
	    return ((java.util.LinkedList) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getTicketingStatus(Showtime)
    public java.util.LinkedList getTicketingStatus(popt.data.Showtime $param_Showtime_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getTicketingStatus_1, new java.lang.Object[] {$param_Showtime_1}, -5752729459485921429L);
	    return ((java.util.LinkedList) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of searchAvailableSeats(Showtime, int)
    public popt.data.Seat[] searchAvailableSeats(popt.data.Showtime $param_Showtime_1, int $param_int_2)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_searchAvailableSeats_2, new java.lang.Object[] {$param_Showtime_1, new java.lang.Integer($param_int_2)}, -9005784249918275926L);
	    return ((popt.data.Seat[]) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of searchAvailableSpecialSeats(Showtime, int)
    public int[] searchAvailableSpecialSeats(popt.data.Showtime $param_Showtime_1, int $param_int_2)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_searchAvailableSpecialSeats_3, new java.lang.Object[] {$param_Showtime_1, new java.lang.Integer($param_int_2)}, -2718007344613818318L);
	    return ((int[]) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of sellSeat(Showtime, Seat[])
    public void sellSeat(popt.data.Showtime $param_Showtime_1, popt.data.Seat[] $param_arrayOf_Seat_2)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_sellSeat_4, new java.lang.Object[] {$param_Showtime_1, $param_arrayOf_Seat_2}, -8198920641952847121L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of sellSpecialSeat(Showtime, int)
    public void sellSpecialSeat(popt.data.Showtime $param_Showtime_1, int $param_int_2)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_sellSpecialSeat_5, new java.lang.Object[] {$param_Showtime_1, new java.lang.Integer($param_int_2)}, -4483055902804053159L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}