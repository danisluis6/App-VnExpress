package com.example.enclaveit.version3.utils;

import android.util.Log;
import android.util.Xml;

import com.example.enclaveit.version3.model.bean.RssItem;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PcWorldRssParser {

    private static final String TAG_TITLE = "title";
    private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_DATE = "pubDate";
    private static final String TAG_LINK = "link";
    private static final String TAG_RSS = "rss";

    private final String ns = null;

    public List<RssItem> parse(InputStream inputStream) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(inputStream, null);
            parser.nextTag();
            return readFeed(parser);
        } finally {
            inputStream.close();
        }
    }

    private List<RssItem> readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, null, TAG_RSS);
        String title = null;
        String description = null;
        String date = null;
        String link = null;
        List<RssItem> items = new ArrayList<RssItem>();
        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals(TAG_TITLE)) {
                title = readTitle(parser);
            } else if(name.equals(TAG_DESCRIPTION)){
                description = readDescription(parser);
            } else if(name.equals(TAG_DATE)){
                 date = readDate(parser);
            } else if (name.equals(TAG_LINK)) {
                link = readLink(parser);
            }
            if (title != null && link != null && description != null) {
                /**
                 * @author: Lorence
                 * Check data from website
                 */
                // Log.d("RSS 1",String.valueOf(item.getDescription()));
                Log.d("RSS Image Link",StringUtils.getImageURL(String.valueOf(description)));
                Log.d("RSS URL Link",StringUtils.getURL(String.valueOf(description)));
                Log.d("RSS Description",StringUtils.getDescriptionNew(String.valueOf(description)));
                RssItem item = new RssItem(title, StringUtils.getDescriptionNew(String.valueOf(description)),date,link,StringUtils.getImageURL(String.valueOf(description)),StringUtils.getURL(String.valueOf(description)));
                if(!("Tin nhanh VnExpress - Đọc báo, tin tức online 24h".equals(title))){
                    items.add(item);
                }
                // Reset Data and continue to get from website
                title = null;
                description = null;
                date = null;
                link = null;
            }
        }
        return items;
    }

    private String readLink(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, TAG_LINK);
        String link = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, TAG_LINK);
        return link;
    }

    private String readTitle(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, TAG_TITLE);
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, TAG_TITLE);
        return title;
    }

    private String readDescription(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, TAG_DESCRIPTION);
        String description = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, TAG_DESCRIPTION);
        return description;
    }

    private String readDate(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, TAG_DATE);
        String date = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, TAG_DATE);
        return date;
    }

    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }
}
