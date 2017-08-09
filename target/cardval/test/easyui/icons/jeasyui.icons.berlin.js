(function ($, undefined) {

    $.util.namespace("$.easyui.icons");

    var iconData = [
        { iconCls: "icon-berlin-address", cls: ".icon-berlin-address", text: "icon-berlin-address", path: "icon-berlin/16x16/address.png" },
        { iconCls: "icon-berlin-administrative-docs", cls: ".icon-berlin-administrative-docs", text: "icon-berlin-administrative-docs", path: "icon-berlin/16x16/administrative-docs.png" },
        { iconCls: "icon-berlin-advertisment", cls: ".icon-berlin-advertisment", text: "icon-berlin-advertisment", path: "icon-berlin/16x16/advertisment.png" },
        { iconCls: "icon-berlin-archives", cls: ".icon-berlin-archives", text: "icon-berlin-archives", path: "icon-berlin/16x16/archives.png" },
        { iconCls: "icon-berlin-attibutes", cls: ".icon-berlin-attibutes", text: "icon-berlin-attibutes", path: "icon-berlin/16x16/attibutes.png" },
        { iconCls: "icon-berlin-bank", cls: ".icon-berlin-bank", text: "icon-berlin-bank", path: "icon-berlin/16x16/bank.png" },
        { iconCls: "icon-berlin-basket", cls: ".icon-berlin-basket", text: "icon-berlin-basket", path: "icon-berlin/16x16/basket.png" },
        { iconCls: "icon-berlin-bestseller", cls: ".icon-berlin-bestseller", text: "icon-berlin-bestseller", path: "icon-berlin/16x16/bestseller.png" },
        { iconCls: "icon-berlin-billing", cls: ".icon-berlin-billing", text: "icon-berlin-billing", path: "icon-berlin/16x16/billing.png" },
        { iconCls: "icon-berlin-bookmark", cls: ".icon-berlin-bookmark", text: "icon-berlin-bookmark", path: "icon-berlin/16x16/bookmark.png" },
        { iconCls: "icon-berlin-brainstorming", cls: ".icon-berlin-brainstorming", text: "icon-berlin-brainstorming", path: "icon-berlin/16x16/brainstorming.png" },
        { iconCls: "icon-berlin-brand", cls: ".icon-berlin-brand", text: "icon-berlin-brand", path: "icon-berlin/16x16/brand.png" },
        { iconCls: "icon-berlin-business-contact", cls: ".icon-berlin-business-contact", text: "icon-berlin-business-contact", path: "icon-berlin/16x16/business-contact.png" },
        { iconCls: "icon-berlin-busy", cls: ".icon-berlin-busy", text: "icon-berlin-busy", path: "icon-berlin/16x16/busy.png" },
        { iconCls: "icon-berlin-calendar", cls: ".icon-berlin-calendar", text: "icon-berlin-calendar", path: "icon-berlin/16x16/calendar.png" },
        { iconCls: "icon-berlin-category-2", cls: ".icon-berlin-category-2", text: "icon-berlin-category-2", path: "icon-berlin/16x16/category-2.png" },
        { iconCls: "icon-berlin-category", cls: ".icon-berlin-category", text: "icon-berlin-category", path: "icon-berlin/16x16/category.png" },
        { iconCls: "icon-berlin-collaboration", cls: ".icon-berlin-collaboration", text: "icon-berlin-collaboration", path: "icon-berlin/16x16/collaboration.png" },
        { iconCls: "icon-berlin-comment", cls: ".icon-berlin-comment", text: "icon-berlin-comment", path: "icon-berlin/16x16/comment.png" },
        { iconCls: "icon-berlin-communication", cls: ".icon-berlin-communication", text: "icon-berlin-communication", path: "icon-berlin/16x16/communication.png" },
        { iconCls: "icon-berlin-config", cls: ".icon-berlin-config", text: "icon-berlin-config", path: "icon-berlin/16x16/config.png" },
        { iconCls: "icon-berlin-consulting", cls: ".icon-berlin-consulting", text: "icon-berlin-consulting", path: "icon-berlin/16x16/consulting.png" },
        { iconCls: "icon-berlin-contact", cls: ".icon-berlin-contact", text: "icon-berlin-contact", path: "icon-berlin/16x16/contact.png" },
        { iconCls: "icon-berlin-cost", cls: ".icon-berlin-cost", text: "icon-berlin-cost", path: "icon-berlin/16x16/cost.png" },
        { iconCls: "icon-berlin-credit-card", cls: ".icon-berlin-credit-card", text: "icon-berlin-credit-card", path: "icon-berlin/16x16/credit-card.png" },
        { iconCls: "icon-berlin-credit", cls: ".icon-berlin-credit", text: "icon-berlin-credit", path: "icon-berlin/16x16/credit.png" },
        { iconCls: "icon-berlin-current-work", cls: ".icon-berlin-current-work", text: "icon-berlin-current-work", path: "icon-berlin/16x16/current-work.png" },
        { iconCls: "icon-berlin-customers", cls: ".icon-berlin-customers", text: "icon-berlin-customers", path: "icon-berlin/16x16/customers.png" },
        { iconCls: "icon-berlin-cv", cls: ".icon-berlin-cv", text: "icon-berlin-cv", path: "icon-berlin/16x16/cv.png" },
        { iconCls: "icon-berlin-database", cls: ".icon-berlin-database", text: "icon-berlin-database", path: "icon-berlin/16x16/database.png" },
        { iconCls: "icon-berlin-date", cls: ".icon-berlin-date", text: "icon-berlin-date", path: "icon-berlin/16x16/date.png" },
        { iconCls: "icon-berlin-delicious", cls: ".icon-berlin-delicious", text: "icon-berlin-delicious", path: "icon-berlin/16x16/delicious.png" },
        { iconCls: "icon-berlin-document-library", cls: ".icon-berlin-document-library", text: "icon-berlin-document-library", path: "icon-berlin/16x16/document-library.png" },
        { iconCls: "icon-berlin-donate", cls: ".icon-berlin-donate", text: "icon-berlin-donate", path: "icon-berlin/16x16/donate.png" },
        { iconCls: "icon-berlin-drawings", cls: ".icon-berlin-drawings", text: "icon-berlin-drawings", path: "icon-berlin/16x16/drawings.png" },
        { iconCls: "icon-berlin-edit", cls: ".icon-berlin-edit", text: "icon-berlin-edit", path: "icon-berlin/16x16/edit.png" },
        { iconCls: "icon-berlin-email", cls: ".icon-berlin-email", text: "icon-berlin-email", path: "icon-berlin/16x16/email.png" },
        { iconCls: "icon-berlin-featured", cls: ".icon-berlin-featured", text: "icon-berlin-featured", path: "icon-berlin/16x16/featured.png" },
        { iconCls: "icon-berlin-feed", cls: ".icon-berlin-feed", text: "icon-berlin-feed", path: "icon-berlin/16x16/feed.png" },
        { iconCls: "icon-berlin-finished-work", cls: ".icon-berlin-finished-work", text: "icon-berlin-finished-work", path: "icon-berlin/16x16/finished-work.png" },
        { iconCls: "icon-berlin-flag", cls: ".icon-berlin-flag", text: "icon-berlin-flag", path: "icon-berlin/16x16/flag.png" },
        { iconCls: "icon-berlin-folder", cls: ".icon-berlin-folder", text: "icon-berlin-folder", path: "icon-berlin/16x16/folder.png" },
        { iconCls: "icon-berlin-free-for-job", cls: ".icon-berlin-free-for-job", text: "icon-berlin-free-for-job", path: "icon-berlin/16x16/free-for-job.png" },
        { iconCls: "icon-berlin-freelance", cls: ".icon-berlin-freelance", text: "icon-berlin-freelance", path: "icon-berlin/16x16/freelance.png" },
        { iconCls: "icon-berlin-full-time", cls: ".icon-berlin-full-time", text: "icon-berlin-full-time", path: "icon-berlin/16x16/full-time.png" },
        { iconCls: "icon-berlin-future-projects", cls: ".icon-berlin-future-projects", text: "icon-berlin-future-projects", path: "icon-berlin/16x16/future-projects.png" },
        { iconCls: "icon-berlin-graphic-design", cls: ".icon-berlin-graphic-design", text: "icon-berlin-graphic-design", path: "icon-berlin/16x16/graphic-design.png" },
        { iconCls: "icon-berlin-heart", cls: ".icon-berlin-heart", text: "icon-berlin-heart", path: "icon-berlin/16x16/heart.png" },
        { iconCls: "icon-berlin-hire-me", cls: ".icon-berlin-hire-me", text: "icon-berlin-hire-me", path: "icon-berlin/16x16/hire-me.png" },
        { iconCls: "icon-berlin-home", cls: ".icon-berlin-home", text: "icon-berlin-home", path: "icon-berlin/16x16/home.png" },
        { iconCls: "icon-berlin-illustration", cls: ".icon-berlin-illustration", text: "icon-berlin-illustration", path: "icon-berlin/16x16/illustration.png" },
        { iconCls: "icon-berlin-invoice-2", cls: ".icon-berlin-invoice-2", text: "icon-berlin-invoice-2", path: "icon-berlin/16x16/invoice-2.png" },
        { iconCls: "icon-berlin-invoice", cls: ".icon-berlin-invoice", text: "icon-berlin-invoice", path: "icon-berlin/16x16/invoice.png" },
        { iconCls: "icon-berlin-issue", cls: ".icon-berlin-issue", text: "icon-berlin-issue", path: "icon-berlin/16x16/issue.png" },
        { iconCls: "icon-berlin-library", cls: ".icon-berlin-library", text: "icon-berlin-library", path: "icon-berlin/16x16/library.png" },
        { iconCls: "icon-berlin-lightbulb", cls: ".icon-berlin-lightbulb", text: "icon-berlin-lightbulb", path: "icon-berlin/16x16/lightbulb.png" },
        { iconCls: "icon-berlin-limited-edition", cls: ".icon-berlin-limited-edition", text: "icon-berlin-limited-edition", path: "icon-berlin/16x16/limited-edition.png" },
        { iconCls: "icon-berlin-link", cls: ".icon-berlin-link", text: "icon-berlin-link", path: "icon-berlin/16x16/link.png" },
        { iconCls: "icon-berlin-lock", cls: ".icon-berlin-lock", text: "icon-berlin-lock", path: "icon-berlin/16x16/lock.png" },
        { iconCls: "icon-berlin-login", cls: ".icon-berlin-login", text: "icon-berlin-login", path: "icon-berlin/16x16/login.png" },
        { iconCls: "icon-berlin-logout", cls: ".icon-berlin-logout", text: "icon-berlin-logout", path: "icon-berlin/16x16/logout.png" },
        { iconCls: "icon-berlin-milestone", cls: ".icon-berlin-milestone", text: "icon-berlin-milestone", path: "icon-berlin/16x16/milestone.png" },
        { iconCls: "icon-berlin-my-account", cls: ".icon-berlin-my-account", text: "icon-berlin-my-account", path: "icon-berlin/16x16/my-account.png" },
        { iconCls: "icon-berlin-networking", cls: ".icon-berlin-networking", text: "icon-berlin-networking", path: "icon-berlin/16x16/networking.png" },
        { iconCls: "icon-berlin-old-version", cls: ".icon-berlin-old-version", text: "icon-berlin-old-version", path: "icon-berlin/16x16/old-version.png" },
        { iconCls: "icon-berlin-order-2", cls: ".icon-berlin-order-2", text: "icon-berlin-order-2", path: "icon-berlin/16x16/order-2.png" },
        { iconCls: "icon-berlin-order", cls: ".icon-berlin-order", text: "icon-berlin-order", path: "icon-berlin/16x16/order.png" },
        { iconCls: "icon-berlin-payment-card", cls: ".icon-berlin-payment-card", text: "icon-berlin-payment-card", path: "icon-berlin/16x16/payment-card.png" },
        { iconCls: "icon-berlin-paypal", cls: ".icon-berlin-paypal", text: "icon-berlin-paypal", path: "icon-berlin/16x16/paypal.png" },
        { iconCls: "icon-berlin-pen", cls: ".icon-berlin-pen", text: "icon-berlin-pen", path: "icon-berlin/16x16/pen.png" },
        { iconCls: "icon-berlin-pencil", cls: ".icon-berlin-pencil", text: "icon-berlin-pencil", path: "icon-berlin/16x16/pencil.png" },
        { iconCls: "icon-berlin-phone", cls: ".icon-berlin-phone", text: "icon-berlin-phone", path: "icon-berlin/16x16/phone.png" },
        { iconCls: "icon-berlin-photography", cls: ".icon-berlin-photography", text: "icon-berlin-photography", path: "icon-berlin/16x16/photography.png" },
        { iconCls: "icon-berlin-premium", cls: ".icon-berlin-premium", text: "icon-berlin-premium", path: "icon-berlin/16x16/premium.png" },
        { iconCls: "icon-berlin-print", cls: ".icon-berlin-print", text: "icon-berlin-print", path: "icon-berlin/16x16/print.png" },
        { iconCls: "icon-berlin-process", cls: ".icon-berlin-process", text: "icon-berlin-process", path: "icon-berlin/16x16/process.png" },
        { iconCls: "icon-berlin-product-2", cls: ".icon-berlin-product-2", text: "icon-berlin-product-2", path: "icon-berlin/16x16/product-2.png" },
        { iconCls: "icon-berlin-product-design", cls: ".icon-berlin-product-design", text: "icon-berlin-product-design", path: "icon-berlin/16x16/product-design.png" },
        { iconCls: "icon-berlin-product", cls: ".icon-berlin-product", text: "icon-berlin-product", path: "icon-berlin/16x16/product.png" },
        { iconCls: "icon-berlin-project", cls: ".icon-berlin-project", text: "icon-berlin-project", path: "icon-berlin/16x16/project.png" },
        { iconCls: "icon-berlin-publish", cls: ".icon-berlin-publish", text: "icon-berlin-publish", path: "icon-berlin/16x16/publish.png" },
        { iconCls: "icon-berlin-refresh", cls: ".icon-berlin-refresh", text: "icon-berlin-refresh", path: "icon-berlin/16x16/refresh.png" },
        { iconCls: "icon-berlin-search", cls: ".icon-berlin-search", text: "icon-berlin-search", path: "icon-berlin/16x16/search.png" },
        { iconCls: "icon-berlin-settings", cls: ".icon-berlin-settings", text: "icon-berlin-settings", path: "icon-berlin/16x16/settings.png" },
        { iconCls: "icon-berlin-shipping", cls: ".icon-berlin-shipping", text: "icon-berlin-shipping", path: "icon-berlin/16x16/shipping.png" },
        { iconCls: "icon-berlin-showreel", cls: ".icon-berlin-showreel", text: "icon-berlin-showreel", path: "icon-berlin/16x16/showreel.png" },
        { iconCls: "icon-berlin-sign-in", cls: ".icon-berlin-sign-in", text: "icon-berlin-sign-in", path: "icon-berlin/16x16/sign-in.png" },
        { iconCls: "icon-berlin-sign-out", cls: ".icon-berlin-sign-out", text: "icon-berlin-sign-out", path: "icon-berlin/16x16/sign-out.png" },
        { iconCls: "icon-berlin-sign-up", cls: ".icon-berlin-sign-up", text: "icon-berlin-sign-up", path: "icon-berlin/16x16/sign-up.png" },
        { iconCls: "icon-berlin-sitemap", cls: ".icon-berlin-sitemap", text: "icon-berlin-sitemap", path: "icon-berlin/16x16/sitemap.png" },
        { iconCls: "icon-berlin-special-offer", cls: ".icon-berlin-special-offer", text: "icon-berlin-special-offer", path: "icon-berlin/16x16/special-offer.png" },
        { iconCls: "icon-berlin-star", cls: ".icon-berlin-star", text: "icon-berlin-star", path: "icon-berlin/16x16/star.png" },
        { iconCls: "icon-berlin-statistics", cls: ".icon-berlin-statistics", text: "icon-berlin-statistics", path: "icon-berlin/16x16/statistics.png" },
        { iconCls: "icon-berlin-suppliers", cls: ".icon-berlin-suppliers", text: "icon-berlin-suppliers", path: "icon-berlin/16x16/suppliers.png" },
        { iconCls: "icon-berlin-tag", cls: ".icon-berlin-tag", text: "icon-berlin-tag", path: "icon-berlin/16x16/tag.png" },
        { iconCls: "icon-berlin-ticket", cls: ".icon-berlin-ticket", text: "icon-berlin-ticket", path: "icon-berlin/16x16/ticket.png" },
        { iconCls: "icon-berlin-twitter", cls: ".icon-berlin-twitter", text: "icon-berlin-twitter", path: "icon-berlin/16x16/twitter.png" },
        { iconCls: "icon-berlin-upcoming-work", cls: ".icon-berlin-upcoming-work", text: "icon-berlin-upcoming-work", path: "icon-berlin/16x16/upcoming-work.png" },
        { iconCls: "icon-berlin-user", cls: ".icon-berlin-user", text: "icon-berlin-user", path: "icon-berlin/16x16/user.png" },
        { iconCls: "icon-berlin-world", cls: ".icon-berlin-world", text: "icon-berlin-world", path: "icon-berlin/16x16/world.png" },


        { iconCls: "icon-berlin-32-address", cls: ".icon-berlin-32-address", text: "icon-berlin-32-address", path: "icon-berlin/32x32/address.png" },
        { iconCls: "icon-berlin-32-administrative-docs", cls: ".icon-berlin-32-administrative-docs", text: "icon-berlin-32-administrative-docs", path: "icon-berlin/32x32/administrative-docs.png" },
        { iconCls: "icon-berlin-32-advertising", cls: ".icon-berlin-32-advertising", text: "icon-berlin-32-advertising", path: "icon-berlin/32x32/advertising.png" },
        { iconCls: "icon-berlin-32-archives", cls: ".icon-berlin-32-archives", text: "icon-berlin-32-archives", path: "icon-berlin/32x32/archives.png" },
        { iconCls: "icon-berlin-32-attibutes", cls: ".icon-berlin-32-attibutes", text: "icon-berlin-32-attibutes", path: "icon-berlin/32x32/attibutes.png" },
        { iconCls: "icon-berlin-32-bank", cls: ".icon-berlin-32-bank", text: "icon-berlin-32-bank", path: "icon-berlin/32x32/bank.png" },
        { iconCls: "icon-berlin-32-basket", cls: ".icon-berlin-32-basket", text: "icon-berlin-32-basket", path: "icon-berlin/32x32/basket.png" },
        { iconCls: "icon-berlin-32-bestseller", cls: ".icon-berlin-32-bestseller", text: "icon-berlin-32-bestseller", path: "icon-berlin/32x32/bestseller.png" },
        { iconCls: "icon-berlin-32-billing", cls: ".icon-berlin-32-billing", text: "icon-berlin-32-billing", path: "icon-berlin/32x32/billing.png" },
        { iconCls: "icon-berlin-32-bookmark", cls: ".icon-berlin-32-bookmark", text: "icon-berlin-32-bookmark", path: "icon-berlin/32x32/bookmark.png" },
        { iconCls: "icon-berlin-32-brainstorming", cls: ".icon-berlin-32-brainstorming", text: "icon-berlin-32-brainstorming", path: "icon-berlin/32x32/brainstorming.png" },
        { iconCls: "icon-berlin-32-brand", cls: ".icon-berlin-32-brand", text: "icon-berlin-32-brand", path: "icon-berlin/32x32/brand.png" },
        { iconCls: "icon-berlin-32-business-contact", cls: ".icon-berlin-32-business-contact", text: "icon-berlin-32-business-contact", path: "icon-berlin/32x32/business-contact.png" },
        { iconCls: "icon-berlin-32-busy", cls: ".icon-berlin-32-busy", text: "icon-berlin-32-busy", path: "icon-berlin/32x32/busy.png" },
        { iconCls: "icon-berlin-32-calendar", cls: ".icon-berlin-32-calendar", text: "icon-berlin-32-calendar", path: "icon-berlin/32x32/calendar.png" },
        { iconCls: "icon-berlin-32-category-2", cls: ".icon-berlin-32-category-2", text: "icon-berlin-32-category-2", path: "icon-berlin/32x32/category-2.png" },
        { iconCls: "icon-berlin-32-categoty", cls: ".icon-berlin-32-categoty", text: "icon-berlin-32-categoty", path: "icon-berlin/32x32/categoty.png" },
        { iconCls: "icon-berlin-32-collaboration", cls: ".icon-berlin-32-collaboration", text: "icon-berlin-32-collaboration", path: "icon-berlin/32x32/collaboration.png" },
        { iconCls: "icon-berlin-32-comment", cls: ".icon-berlin-32-comment", text: "icon-berlin-32-comment", path: "icon-berlin/32x32/comment.png" },
        { iconCls: "icon-berlin-32-communication", cls: ".icon-berlin-32-communication", text: "icon-berlin-32-communication", path: "icon-berlin/32x32/communication.png" },
        { iconCls: "icon-berlin-32-config", cls: ".icon-berlin-32-config", text: "icon-berlin-32-config", path: "icon-berlin/32x32/config.png" },
        { iconCls: "icon-berlin-32-consulting", cls: ".icon-berlin-32-consulting", text: "icon-berlin-32-consulting", path: "icon-berlin/32x32/consulting.png" },
        { iconCls: "icon-berlin-32-contact", cls: ".icon-berlin-32-contact", text: "icon-berlin-32-contact", path: "icon-berlin/32x32/contact.png" },
        { iconCls: "icon-berlin-32-cost", cls: ".icon-berlin-32-cost", text: "icon-berlin-32-cost", path: "icon-berlin/32x32/cost.png" },
        { iconCls: "icon-berlin-32-credit-card", cls: ".icon-berlin-32-credit-card", text: "icon-berlin-32-credit-card", path: "icon-berlin/32x32/credit-card.png" },
        { iconCls: "icon-berlin-32-credit", cls: ".icon-berlin-32-credit", text: "icon-berlin-32-credit", path: "icon-berlin/32x32/credit.png" },
        { iconCls: "icon-berlin-32-current-work", cls: ".icon-berlin-32-current-work", text: "icon-berlin-32-current-work", path: "icon-berlin/32x32/current-work.png" },
        { iconCls: "icon-berlin-32-customers", cls: ".icon-berlin-32-customers", text: "icon-berlin-32-customers", path: "icon-berlin/32x32/customers.png" },
        { iconCls: "icon-berlin-32-cv", cls: ".icon-berlin-32-cv", text: "icon-berlin-32-cv", path: "icon-berlin/32x32/cv.png" },
        { iconCls: "icon-berlin-32-database", cls: ".icon-berlin-32-database", text: "icon-berlin-32-database", path: "icon-berlin/32x32/database.png" },
        { iconCls: "icon-berlin-32-date", cls: ".icon-berlin-32-date", text: "icon-berlin-32-date", path: "icon-berlin/32x32/date.png" },
        { iconCls: "icon-berlin-32-delicious", cls: ".icon-berlin-32-delicious", text: "icon-berlin-32-delicious", path: "icon-berlin/32x32/delicious.png" },
        { iconCls: "icon-berlin-32-document-library", cls: ".icon-berlin-32-document-library", text: "icon-berlin-32-document-library", path: "icon-berlin/32x32/document-library.png" },
        { iconCls: "icon-berlin-32-donate", cls: ".icon-berlin-32-donate", text: "icon-berlin-32-donate", path: "icon-berlin/32x32/donate.png" },
        { iconCls: "icon-berlin-32-drawings", cls: ".icon-berlin-32-drawings", text: "icon-berlin-32-drawings", path: "icon-berlin/32x32/drawings.png" },
        { iconCls: "icon-berlin-32-edit", cls: ".icon-berlin-32-edit", text: "icon-berlin-32-edit", path: "icon-berlin/32x32/edit.png" },
        { iconCls: "icon-berlin-32-email", cls: ".icon-berlin-32-email", text: "icon-berlin-32-email", path: "icon-berlin/32x32/email.png" },
        { iconCls: "icon-berlin-32-featured", cls: ".icon-berlin-32-featured", text: "icon-berlin-32-featured", path: "icon-berlin/32x32/featured.png" },
        { iconCls: "icon-berlin-32-feed", cls: ".icon-berlin-32-feed", text: "icon-berlin-32-feed", path: "icon-berlin/32x32/feed.png" },
        { iconCls: "icon-berlin-32-finished-work", cls: ".icon-berlin-32-finished-work", text: "icon-berlin-32-finished-work", path: "icon-berlin/32x32/finished-work.png" },
        { iconCls: "icon-berlin-32-flag", cls: ".icon-berlin-32-flag", text: "icon-berlin-32-flag", path: "icon-berlin/32x32/flag.png" },
        { iconCls: "icon-berlin-32-folder", cls: ".icon-berlin-32-folder", text: "icon-berlin-32-folder", path: "icon-berlin/32x32/folder.png" },
        { iconCls: "icon-berlin-32-free-for-job", cls: ".icon-berlin-32-free-for-job", text: "icon-berlin-32-free-for-job", path: "icon-berlin/32x32/free-for-job.png" },
        { iconCls: "icon-berlin-32-freelance", cls: ".icon-berlin-32-freelance", text: "icon-berlin-32-freelance", path: "icon-berlin/32x32/freelance.png" },
        { iconCls: "icon-berlin-32-full-time", cls: ".icon-berlin-32-full-time", text: "icon-berlin-32-full-time", path: "icon-berlin/32x32/full-time.png" },
        { iconCls: "icon-berlin-32-future-projects", cls: ".icon-berlin-32-future-projects", text: "icon-berlin-32-future-projects", path: "icon-berlin/32x32/future-projects.png" },
        { iconCls: "icon-berlin-32-graphic-design", cls: ".icon-berlin-32-graphic-design", text: "icon-berlin-32-graphic-design", path: "icon-berlin/32x32/graphic-design.png" },
        { iconCls: "icon-berlin-32-heart", cls: ".icon-berlin-32-heart", text: "icon-berlin-32-heart", path: "icon-berlin/32x32/heart.png" },
        { iconCls: "icon-berlin-32-hire-me", cls: ".icon-berlin-32-hire-me", text: "icon-berlin-32-hire-me", path: "icon-berlin/32x32/hire-me.png" },
        { iconCls: "icon-berlin-32-home", cls: ".icon-berlin-32-home", text: "icon-berlin-32-home", path: "icon-berlin/32x32/home.png" },
        { iconCls: "icon-berlin-32-illustration", cls: ".icon-berlin-32-illustration", text: "icon-berlin-32-illustration", path: "icon-berlin/32x32/illustration.png" },
        { iconCls: "icon-berlin-32-invoice-2", cls: ".icon-berlin-32-invoice-2", text: "icon-berlin-32-invoice-2", path: "icon-berlin/32x32/invoice-2.png" },
        { iconCls: "icon-berlin-32-invoice", cls: ".icon-berlin-32-invoice", text: "icon-berlin-32-invoice", path: "icon-berlin/32x32/invoice.png" },
        { iconCls: "icon-berlin-32-issue", cls: ".icon-berlin-32-issue", text: "icon-berlin-32-issue", path: "icon-berlin/32x32/issue.png" },
        { iconCls: "icon-berlin-32-library", cls: ".icon-berlin-32-library", text: "icon-berlin-32-library", path: "icon-berlin/32x32/library.png" },
        { iconCls: "icon-berlin-32-lightbulb", cls: ".icon-berlin-32-lightbulb", text: "icon-berlin-32-lightbulb", path: "icon-berlin/32x32/lightbulb.png" },
        { iconCls: "icon-berlin-32-limited-edition", cls: ".icon-berlin-32-limited-edition", text: "icon-berlin-32-limited-edition", path: "icon-berlin/32x32/limited-edition.png" },
        { iconCls: "icon-berlin-32-link", cls: ".icon-berlin-32-link", text: "icon-berlin-32-link", path: "icon-berlin/32x32/link.png" },
        { iconCls: "icon-berlin-32-lock", cls: ".icon-berlin-32-lock", text: "icon-berlin-32-lock", path: "icon-berlin/32x32/lock.png" },
        { iconCls: "icon-berlin-32-login", cls: ".icon-berlin-32-login", text: "icon-berlin-32-login", path: "icon-berlin/32x32/login.png" },
        { iconCls: "icon-berlin-32-logout", cls: ".icon-berlin-32-logout", text: "icon-berlin-32-logout", path: "icon-berlin/32x32/logout.png" },
        { iconCls: "icon-berlin-32-milestone", cls: ".icon-berlin-32-milestone", text: "icon-berlin-32-milestone", path: "icon-berlin/32x32/milestone.png" },
        { iconCls: "icon-berlin-32-my-account", cls: ".icon-berlin-32-my-account", text: "icon-berlin-32-my-account", path: "icon-berlin/32x32/my-account.png" },
        { iconCls: "icon-berlin-32-networking", cls: ".icon-berlin-32-networking", text: "icon-berlin-32-networking", path: "icon-berlin/32x32/networking.png" },
        { iconCls: "icon-berlin-32-old-versions", cls: ".icon-berlin-32-old-versions", text: "icon-berlin-32-old-versions", path: "icon-berlin/32x32/old-versions.png" },
        { iconCls: "icon-berlin-32-order-2", cls: ".icon-berlin-32-order-2", text: "icon-berlin-32-order-2", path: "icon-berlin/32x32/order-2.png" },
        { iconCls: "icon-berlin-32-order", cls: ".icon-berlin-32-order", text: "icon-berlin-32-order", path: "icon-berlin/32x32/order.png" },
        { iconCls: "icon-berlin-32-payment-card", cls: ".icon-berlin-32-payment-card", text: "icon-berlin-32-payment-card", path: "icon-berlin/32x32/payment-card.png" },
        { iconCls: "icon-berlin-32-paypal", cls: ".icon-berlin-32-paypal", text: "icon-berlin-32-paypal", path: "icon-berlin/32x32/paypal.png" },
        { iconCls: "icon-berlin-32-pen", cls: ".icon-berlin-32-pen", text: "icon-berlin-32-pen", path: "icon-berlin/32x32/pen.png" },
        { iconCls: "icon-berlin-32-pencil", cls: ".icon-berlin-32-pencil", text: "icon-berlin-32-pencil", path: "icon-berlin/32x32/pencil.png" },
        { iconCls: "icon-berlin-32-phone", cls: ".icon-berlin-32-phone", text: "icon-berlin-32-phone", path: "icon-berlin/32x32/phone.png" },
        { iconCls: "icon-berlin-32-photography", cls: ".icon-berlin-32-photography", text: "icon-berlin-32-photography", path: "icon-berlin/32x32/photography.png" },
        { iconCls: "icon-berlin-32-premium", cls: ".icon-berlin-32-premium", text: "icon-berlin-32-premium", path: "icon-berlin/32x32/premium.png" },
        { iconCls: "icon-berlin-32-print", cls: ".icon-berlin-32-print", text: "icon-berlin-32-print", path: "icon-berlin/32x32/print.png" },
        { iconCls: "icon-berlin-32-process", cls: ".icon-berlin-32-process", text: "icon-berlin-32-process", path: "icon-berlin/32x32/process.png" },
        { iconCls: "icon-berlin-32-product-2", cls: ".icon-berlin-32-product-2", text: "icon-berlin-32-product-2", path: "icon-berlin/32x32/product-2.png" },
        { iconCls: "icon-berlin-32-product-design", cls: ".icon-berlin-32-product-design", text: "icon-berlin-32-product-design", path: "icon-berlin/32x32/product-design.png" },
        { iconCls: "icon-berlin-32-product", cls: ".icon-berlin-32-product", text: "icon-berlin-32-product", path: "icon-berlin/32x32/product.png" },
        { iconCls: "icon-berlin-32-project", cls: ".icon-berlin-32-project", text: "icon-berlin-32-project", path: "icon-berlin/32x32/project.png" },
        { iconCls: "icon-berlin-32-publish", cls: ".icon-berlin-32-publish", text: "icon-berlin-32-publish", path: "icon-berlin/32x32/publish.png" },
        { iconCls: "icon-berlin-32-refresh", cls: ".icon-berlin-32-refresh", text: "icon-berlin-32-refresh", path: "icon-berlin/32x32/refresh.png" },
        { iconCls: "icon-berlin-32-search", cls: ".icon-berlin-32-search", text: "icon-berlin-32-search", path: "icon-berlin/32x32/search.png" },
        { iconCls: "icon-berlin-32-settings", cls: ".icon-berlin-32-settings", text: "icon-berlin-32-settings", path: "icon-berlin/32x32/settings.png" },
        { iconCls: "icon-berlin-32-shipping", cls: ".icon-berlin-32-shipping", text: "icon-berlin-32-shipping", path: "icon-berlin/32x32/shipping.png" },
        { iconCls: "icon-berlin-32-showreel", cls: ".icon-berlin-32-showreel", text: "icon-berlin-32-showreel", path: "icon-berlin/32x32/showreel.png" },
        { iconCls: "icon-berlin-32-sign-in", cls: ".icon-berlin-32-sign-in", text: "icon-berlin-32-sign-in", path: "icon-berlin/32x32/sign-in.png" },
        { iconCls: "icon-berlin-32-sign-out", cls: ".icon-berlin-32-sign-out", text: "icon-berlin-32-sign-out", path: "icon-berlin/32x32/sign-out.png" },
        { iconCls: "icon-berlin-32-sign-up", cls: ".icon-berlin-32-sign-up", text: "icon-berlin-32-sign-up", path: "icon-berlin/32x32/sign-up.png" },
        { iconCls: "icon-berlin-32-sitemap", cls: ".icon-berlin-32-sitemap", text: "icon-berlin-32-sitemap", path: "icon-berlin/32x32/sitemap.png" },
        { iconCls: "icon-berlin-32-special-offer", cls: ".icon-berlin-32-special-offer", text: "icon-berlin-32-special-offer", path: "icon-berlin/32x32/special-offer.png" },
        { iconCls: "icon-berlin-32-star", cls: ".icon-berlin-32-star", text: "icon-berlin-32-star", path: "icon-berlin/32x32/star.png" },
        { iconCls: "icon-berlin-32-statistics", cls: ".icon-berlin-32-statistics", text: "icon-berlin-32-statistics", path: "icon-berlin/32x32/statistics.png" },
        { iconCls: "icon-berlin-32-suppliers", cls: ".icon-berlin-32-suppliers", text: "icon-berlin-32-suppliers", path: "icon-berlin/32x32/suppliers.png" },
        { iconCls: "icon-berlin-32-tag", cls: ".icon-berlin-32-tag", text: "icon-berlin-32-tag", path: "icon-berlin/32x32/tag.png" },
        { iconCls: "icon-berlin-32-ticket", cls: ".icon-berlin-32-ticket", text: "icon-berlin-32-ticket", path: "icon-berlin/32x32/ticket.png" },
        { iconCls: "icon-berlin-32-twitter", cls: ".icon-berlin-32-twitter", text: "icon-berlin-32-twitter", path: "icon-berlin/32x32/twitter.png" },
        { iconCls: "icon-berlin-32-upcoming-work", cls: ".icon-berlin-32-upcoming-work", text: "icon-berlin-32-upcoming-work", path: "icon-berlin/32x32/upcoming-work.png" },
        { iconCls: "icon-berlin-32-user", cls: ".icon-berlin-32-user", text: "icon-berlin-32-user", path: "icon-berlin/32x32/user.png" },
        { iconCls: "icon-berlin-32-world", cls: ".icon-berlin-32-world", text: "icon-berlin-32-world", path: "icon-berlin/32x32/world.png" }
    ];

    $.easyui.icons.berlin = iconData;

    var iconStyle = { name: "berlin", size: "16,32" };
    if ($.isArray($.easyui.iconStyles)) { $.array.merge($.easyui.iconStyles, iconStyle); } else { $.easyui.iconStyles = [iconStyle]; }


})(jQuery);