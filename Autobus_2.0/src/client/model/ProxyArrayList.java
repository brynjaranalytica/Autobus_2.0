package client.model;

import client.controller.ClientController;

import java.util.*;

/**
 * Created by lenovo on 4/21/2017.
 */

public class ProxyArrayList<T> implements List<T> {
    private ArrayList<T> realList;
    private ClientController controller;

    public ProxyArrayList() {
        this.controller = ClientController.getInstance();
    }

    private void downloadRealListIfNull(){
        if(realList == null)
            realList = (ArrayList<T>) controller.getToursFromServer();
    }

    public void setRealList(ArrayList<T> realList) {
        this.realList = realList;
    }

    @Override
    public int size() {
        downloadRealListIfNull();
        return realList.size();
    }

    @Override
    public boolean isEmpty() {
        downloadRealListIfNull();
        return realList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        downloadRealListIfNull();
        return realList.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        downloadRealListIfNull();
        return realList.iterator();
    }

    @Override
    public Object[] toArray() {
        downloadRealListIfNull();
        return realList.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        downloadRealListIfNull();
        return realList.toArray(a);
    }

    @Override
    public boolean add(T t) {
        downloadRealListIfNull();
        return realList.add(t);
    }

    @Override
    public boolean remove(Object o) {
        downloadRealListIfNull();
        return realList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        downloadRealListIfNull();

        return realList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        downloadRealListIfNull();

        return realList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        downloadRealListIfNull();

        return realList.addAll(index,c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        downloadRealListIfNull();

        return realList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        downloadRealListIfNull();

        return realList.retainAll(c);
    }

    @Override
    public void clear() {
        downloadRealListIfNull();
        realList.clear();
    }

    @Override
    public T get(int index) {
        downloadRealListIfNull();

        return realList.get(index);
    }

    @Override
    public T set(int index, T element) {
        downloadRealListIfNull();

        return realList.set(index, element);
    }

    @Override
    public void add(int index, T element) {
        downloadRealListIfNull();
        realList.add(index, element);
    }

    @Override
    public T remove(int index) {
        downloadRealListIfNull();

        return realList.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        downloadRealListIfNull();

        return realList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        downloadRealListIfNull();

        return realList.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        downloadRealListIfNull();

        return realList.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        downloadRealListIfNull();

        return realList.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        downloadRealListIfNull();

        return realList.subList(fromIndex, toIndex);
    }
}
