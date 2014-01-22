package com.asayama.gwt.core.client;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.google.gwt.core.client.JsArray;

public class $array<T extends $> extends $ implements List<T> {

	protected $array() {
	}
	
	public static native <T extends $> $array<T> create() /*-{
		return [];
	}-*/;
	
	private final <X extends $> _$array<T> delegate() {
		return this.cast();
	}

	@Override
	public final boolean add(T value) {
		delegate().push(value);
		return false;
	}

	@Override
	public final void add(int arg0, T arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final boolean addAll(int arg0, Collection<? extends T> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final T get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public final boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public final ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final ListIterator<T> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final T remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final T set(int arg0, T arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public final List<T> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final <X> X[] toArray(X[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
class _$array<T extends $> extends JsArray<T> {

	protected _$array() {
	}

}
