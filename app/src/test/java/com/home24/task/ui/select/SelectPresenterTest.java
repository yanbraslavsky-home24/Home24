package com.home24.task.ui.select;


import com.home24.task.R;
import com.home24.task.data.dataManager.DataManager;
import com.home24.task.data.dataManager.network.model.ArticleRequest;
import com.home24.task.data.dataManager.network.model.ArticleResponse;
import com.home24.task.ui.select.SelectMvpView;
import com.home24.task.ui.select.SelectPresenter;
import com.home24.task.utils.rx.SchedulerProvider;
import com.home24.task.utils.rx.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.reactivestreams.Subscriber;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.TestScheduler;

import static com.home24.task.utils.AppConstants.LIMIT;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Alaeddine Khoudi.
 */

@RunWith(MockitoJUnitRunner.class)
public class SelectPresenterTest {

    @Mock
    SelectMvpView selectMvpView;


    @Mock
    DataManager dataManager;

    @Mock
    SchedulerProvider schedulerProvider;


    private TestScheduler testScheduler;

    private SelectPresenter<SelectMvpView> selectPresenter;


    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        testScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(testScheduler);

        selectPresenter = new SelectPresenter<>(
                testSchedulerProvider,
                compositeDisposable,
                dataManager);


        selectPresenter.onAttach(selectMvpView);

    }

    @Test
    public void testFetchArticleSuccess() throws InterruptedException {


        ArticleResponse articleResponse = new ArticleResponse();

        when(selectMvpView.isNetworkConnected()).thenReturn(true);


        selectPresenter.fetchArticleList();
        testScheduler.triggerActions();


        verify(selectMvpView).showLoading();
        verify(selectMvpView).hideLoading();
        verify(selectMvpView).showMainView();
        verify(selectMvpView).fetchedArticles(articleResponse.getEmbedded().getArticles());
    }

    @Test
    public void testErrorNetwrok() throws InterruptedException {


        when(selectMvpView.isNetworkConnected()).thenReturn(false);

        selectPresenter.fetchArticleList();


        verify(selectMvpView).onError(R.string.no_internet);
    }



    @After
    public void tearDown() throws Exception {
        selectPresenter.onDetach();
    }


}