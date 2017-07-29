package ru.alexbykov.novalid;

import android.text.TextUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import ru.alexbykov.novalid.utils.StringUtils;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * Date: 29.07.2017
 * Time: 11:57
 * Project: NoValid
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(TextUtils.class)
public class StringUtilsTest {

    @Before
    public void setUp() {
        mockTextUtils();
    }

    private void mockTextUtils() {
        mockStatic(TextUtils.class);
        PowerMockito.when(TextUtils.isEmpty(any(CharSequence.class))).thenAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocation) throws Throwable {
                CharSequence a = (CharSequence) invocation.getArguments()[0];
                return !(a != null && a.length() > 0);
            }
        });
    }

    @Test
    public void isEmptyTestWithNullValue() {
        final String value = null;
        assertTrue(StringUtils.isEmpty(value));
    }

    @Test
    public void isEmptyTestWithEmptyValue() {
        final String value = "";
        assertTrue(StringUtils.isEmpty(value));
    }

    @Test
    public void isEmptyTestWithOnlySpacesValue() {
        final String value = "       ";
        assertTrue(StringUtils.isEmpty(value));
    }

    @Test
    public void isEmptyTestWithNormalValue() {
        final String value = "test";
        assertFalse(StringUtils.isEmpty(value));
    }

}
